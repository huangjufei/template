package com.hjf.thread.pool.helloworld;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 效果:
 * 运行会报拒接错误,因为最大线程是2,队列是3,循环是6个任务,还有一个任务多出来了,就会触发饱和机制
 * 而且程序最后没有退出;
 *
 * 我原本错误的想法是:线程池中的线程执行完当前任务会自动又去队列获取,这么点任务不存在队列满的情况,结果
 * 2个线程是会自动去领取任务,但是任务数字不能大于线程最大数+队列数字;
 * 但又想了想我在for循环中加入一点延迟就不会出现
 * 线程消费不过来的情况了,也就不会报错了
 *
 * 总结:
 * 线程池的线程运行完当前任务后会自动去领取新任务,但 任务数 > (线程最大数+队列数字)
 * 就会触发饱和机制,这里的任务数是一个多态的时间概念,指的是当前任务数,不是初始任务数,只要线程能
 * 执行过来就不会触发饱和机制.如我们在任务创建连接点时加入延迟时间;任务数就不会激增
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 60L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));

        for (int i = 1; i <= 68; i++) {
            TaskThread t1 = new TaskThread(",任务" + i);
            executor.execute(t1);

            //加入点点延迟可以让线程忙过来,就不会报拒绝
      /*      try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        executor.shutdown();
    }
}

class TaskThread implements Runnable {
    private String taskName;

    public TaskThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + taskName);
    }
}