package com.metersbonwe.stock.test;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor task = new ThreadPoolTaskExecutor();
        task.setCorePoolSize(20);
        task.setMaxPoolSize(20);
        task.afterPropertiesSet();
        
        java.util.concurrent.ExecutorService ss = java.util.concurrent.Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 60; i++) {
            System.out.println(i);
            final int j = i;
            ss.execute(new Runnable() {
                @Override
                public void run() {
                    int k = 10;
                    while(k -- > 0) {
                        try {
                            System.out.println("thread::::" + j);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
