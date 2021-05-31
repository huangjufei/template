package com.hjf.queue.linkedblockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConsumerThread implements Runnable {
    private volatile boolean FLAG = true;
    private BlockingQueue<String> blockingQueue;
    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "消费者开始启动....");
        while (FLAG) {
            try {
                //在指定的时间内如果有数据就取走,如果指定时间到了就返回
                String data = blockingQueue.poll(2,  TimeUnit.MILLISECONDS);
                if (data == null || data == "") {
                  //  FLAG = false;
                    System.out.println("消费者超过2秒时间未获取到消息."+Thread.currentThread().getName());
                    return;
                }
                System.out.println("消费者获取到队列信息成功,"+Thread.currentThread().getName()+"data:" + data);
            } catch (Exception e) {}
        }
    }
}