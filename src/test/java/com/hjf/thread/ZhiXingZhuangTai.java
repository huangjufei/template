package com.hjf.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 线程执行状态:主要方法 执行完成线程数 ;
 *
 *干货教你如何监控 Java 线程池运行状态
 *https://my.oschina.net/javaroad/blog/1816647
 *
 *
 *1,首先看看ExecutorService和ThreadPoolExecutor的关系?
 *  ThreadPoolExecutor extends AbstractExecutorService -->  implements --> ExecutorService extends Executor
 *
 * 2,执行结果 当前活动线程数 始终是50,不代表线程就是50个,从每次完成数只差150说明每次执行完成了150个任务;
 *
 * 3,从每次输出的1也可以看出是150个
 *
 * 4,程序第一次执行了50个1,第二次开始每次都是150个1
 *
 */
public class ZhiXingZhuangTai {

    private static ExecutorService es = new ThreadPoolExecutor(50, 100, 10L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100000));

    public static void main(String[] args) throws Exception {
        String s = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        System.out.println(s.length());

        for (int i = 0; i < 100000; i++) {
            es.execute(() -> {
                System.out.print(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);

        while (true) {
            System.out.println();
            System.out.println("?：" + tpe.getPoolSize());
            System.out.println("??：" + tpe.getMaximumPoolSize());
            System.out.println("当前排队线程数：" + tpe.getQueue().size());
            System.out.println("当前活动线程数：" + tpe.getActiveCount());
            System.out.println("执行完成线程数：" + tpe.getCompletedTaskCount());
            System.out.println("总线程数：" + tpe.getTaskCount());
            Thread.sleep(3000);
        }

    }
}
