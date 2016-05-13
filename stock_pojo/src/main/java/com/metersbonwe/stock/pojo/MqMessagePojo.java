package com.metersbonwe.stock.pojo;

public class MqMessagePojo {
    private String   message;       // 文本消息

    private String proxyClass;    // 消息执行的代理类
    

    private String listenerClass; // MQ监听代理类

    private Object   object;        // 代理类执行的入参

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProxyClass() {
        return proxyClass;
    }

    public void setProxyClass(String proxyClass) {
        this.proxyClass = proxyClass;
    }

    public String getListenerClass() {
        return listenerClass;
    }

    public void setListenerClass(String listenerClass) {
        this.listenerClass = listenerClass;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
