package com.hjf.queue.linkedblockqueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列的初次尝试,这里面有一个时间差导致有一个消费者消费不到,此程序只能作为调式玩玩作用,不能当作生产者和消费者使用,
 * 除非是只启动2个线程
 */
public class Test0005 {
    public static void main(String[] args) {
        //LinkedBlockingQueue会默认一个类似无限大小的容量（Integer.MAX_VALUE），这样的话，
        // 如果生产者的速度一旦大于消费者的速度，也许还没有等到队列满阻塞产生，系统内存就有可能已被消耗殆尽了。
        //开发不建议不指定具体的值,太危险
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
        ProducerThread producer = new ProducerThread(blockingQueue);
        ConsumerThread consumer = new ConsumerThread(blockingQueue);

        Thread p = new Thread(producer);
        Thread p2 = new Thread(producer);
        Thread c = new Thread(consumer);
        Thread c2 = new Thread(consumer);
        Thread c3 = new Thread(consumer);
        p.start();
        p2.start();
        c.start();
        c2.start();
        c3.start();
        try {
            //10秒后停止生产者线程
            Thread.sleep(10*1000);
            producer.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}