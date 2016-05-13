package com.metersbonwe.stock.biz.common.service.mq;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.beans.WirterMethodDescriptor;
import com.metersbonwe.stock.biz.common.localcache.provider.ChannelCodeCacheProvider;
import com.metersbonwe.stock.configuration.PropertiesManager;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

@Service public class MqDynamicRegisteService {

    @Resource(name = "receiveConnectionPoolFactory") private ConnectionFactory connectionFactory;

    private StockLog                                                           log        = StockLogFactory.getLogger(MqDynamicRegisteService.class);

    @Resource ChannelCodeCacheProvider channelCodeCacheProvider;
    

    private Map<String, DefaultMessageListenerContainer>                       containers = Maps.newHashMap();

    private final Object                                                       lock       = new Object();

    /**
     * 注册队列监听
     * 
     * @param queueName
     *            队列名称
     * @param listener
     *            监听器
     * @param concurrency
     *            eg. 1-4
     * @see org.springframework.jms.listener.DefaultMessageListenerContainer
     */
    public void registeQueueLintener(String queueName, MessageListener listener, String concurrency) {
        ActiveMQQueue destination = new ActiveMQQueue(queueName);
        Map<String, Object> param = Maps.newHashMap();
        param.put("destination", destination);
        param.put("connectionFactory", connectionFactory);
        param.put("concurrency", concurrency);
        param.put("messageListener", listener);
        try {
            registeMqLintener(param);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            log.error("registeQueueLintener 注册监听出错:" + e.getMessage(), e);
        }
    }

    /**
     * 注册监听
     * 
     * @param param
     *            参数
     * @see org.springframework.jms.listener.DefaultMessageListenerContainer
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public synchronized void registeMqLintener(Map<String, Object> param)
            throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Assert.notEmpty(param, "参数不能为空");
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            WirterMethodDescriptor descriptor = new WirterMethodDescriptor(entry.getKey(), container.getClass());
            descriptor.getWriteMethod().invoke(container, entry.getValue());
        }
        Destination destination = (Destination) param.get("destination");
        String name = getDestinationName(destination);

        synchronized (lock) {
            if (containers.containsKey(name)) {
                throw new RuntimeException("队列" + name + "已经注册过监听");
            }
            containers.put(name, container);
        }

        container.afterPropertiesSet();
        container.start();
    }

    private String getDestinationName(Destination destination) {
        if (destination instanceof ActiveMQQueue) {
            ActiveMQQueue queue = (ActiveMQQueue) destination;
            return queue.getPhysicalName();
        }
        if (destination instanceof ActiveMQTopic) {
            ActiveMQTopic topic = (ActiveMQTopic) destination;
            return topic.getPhysicalName();
        }
        throw new RuntimeException(" destination is not support !" + destination);
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * 注册默认监听
     * 
     * @param channel
     *            渠道号
     */
    public String registeDefaultQueueLintener(String channel, MessageListener messageListener) {
        Assert.notNull(channel, "注册监听的渠道号为空");
        Assert.state(!channel.trim().isEmpty(), "注册监听的渠道号为空");
        String queueName = PropertiesManager.getPropertiesManager().getProperty("ONLINE_CHANNEL_STOCK") + channel.toLowerCase();
        registeQueueLintener(queueName, messageListener, "1-10");
        return queueName;
    }

    private AtomicBoolean running = new AtomicBoolean(false);

    public void doStart(final MessageListener messageListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning()) {
                    try {
                        List<String> channels = channelCodeCacheProvider.getAllUsefulChannel();
                        addLintener(channels);
                        sleep();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }

            private long sleeptime = 5 * 60 * 1000; //5 min

            protected void sleep() {
                try {
                    Thread.sleep(sleeptime);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            }

            protected void addLintener(List<String> channels) {
                for (int i = 0; i < channels.size(); i++) {
                    try {
                        String channel_code = channels.get(i);
                        synchronized (lock) {
                            if (!containers.containsKey(channel_code) && isRunning()) {
                                registeDefaultQueueLintener(channel_code, messageListener);
                            }
                        }
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }).start();
    }

    public void start(final MessageListener messageListener) {
        if (!isRunning()) {
            running.set(true);
            doStart(messageListener);
        }
    }

    public void stop() {
        if (running.getAndSet(false)) {
            synchronized (lock) {
                for (Map.Entry<String, DefaultMessageListenerContainer> entry : containers.entrySet()) {
                    String channelCode = entry.getKey();
                    DefaultMessageListenerContainer container = containers.remove(channelCode);
                    container.stop();
                }
            }
        }
    }

    public boolean isRunning() {
        return running.get();
    }

}
