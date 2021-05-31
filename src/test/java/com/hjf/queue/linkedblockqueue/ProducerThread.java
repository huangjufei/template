package com.hjf.queue.linkedblockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean FLAG = true;
    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始启动....");
        while (FLAG) {
            String data = count.incrementAndGet() + "";
            try {
                //可以设定等待的时间，如果在指定的时间内，还不能往队列中加入BlockingQueue，则返回失败。
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.MILLISECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "成功..");
                } else {
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "失败..");
                }
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        System.out.println(Thread.currentThread().getName() + ",生产者线程停止...");
    }
    public void stop() {
        this.FLAG = false;
    }
}