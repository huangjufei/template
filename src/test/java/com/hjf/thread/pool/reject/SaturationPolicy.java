package com.hjf.thread.pool.reject;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 java线程池工作队列饱和策略代码示例,推荐
 https://www.jb51.net/article/128887.htm


 饱和策略作用就是在(最大线程数 + 队列数) < 任务数 时就会触发,该如何处理
 饱和策略分为：
 Abort 策略(默认,且JVM没有退出),
 CallerRuns (执行不过来时主线程会参与进来,主线程一旦占用其它线程池的线程不在自动接任务,需要主线程分配),
 Discard策略(丢弃)，
 DiscardOlds策略(不适合优先策略)。

 //线程池拒绝策略及有界无界队列,强烈推荐包含线程池的执行流程,有界和无界队列
 https://www.jianshu.com/p/80b14c4c1ff4
 */
public class SaturationPolicy {
    /**
     * 线程池工作队列已满时，在不同饱和策略下表现
     * @param handler 线程池工作队列饱和策略
     */
    public static void policy(RejectedExecutionHandler handler) {
        //基本线程2个，最大线程数为3，工作队列容量为5
        ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 3, 2L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(5));

        System.out.println("初始值"+exec.getQueue().remainingCapacity());

        if (handler != null) {
            exec.setRejectedExecutionHandler(handler);//如果传入参数则设置饱和策略,这里也可以通过构造器传入,只是这里方便测试不同
        }
        for (int i = 0; i < 20; i++) {
            exec.submit(new Task());//提交任务
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
         //policy(new ThreadPoolExecutor.AbortPolicy());
         // policy((new ThreadPoolExecutor.CallerRunsPolicy()));
        // policy(new ThreadPoolExecutor.DiscardPolicy());
         //policy(new ThreadPoolExecutor.DiscardOldestPolicy());
        policy(new MyReject());

    }

    //自定义任务
    static class Task implements Runnable {
        private static int count = 0;//静态变量
        private int id = 0;

        public Task() {
            id = ++count;//通过静态变量和new无关的,来给每个任务赋值,任务标识
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3); //休眠3秒
            } catch (InterruptedException e) {
                System.err.println("线程被中断" + e.getMessage());
            }
            System.out.println(" 任务：" + id + "\t 工作线程: " + Thread.currentThread().getName() + " 执行完毕");
        }
    }


    /**
     *
     * 自定义JAVA线程池拒绝策略,结合下面看看默认的4种实现基本上就可以看懂下面代码
     * https://zhuanlan.zhihu.com/p/30677474
     * 另:拒绝策略 其它思路 建议队列数始终大于任务数,或加入延迟,或使用mq转存
     */
    public static class MyReject implements RejectedExecutionHandler{

        /**
         * @param runnable 主线程
         * @param threadPoolExecutor 线程池,可以得到队列
         */
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if(!threadPoolExecutor.isShutdown()){
                System.out.println("触发自定义拒绝策略了="+threadPoolExecutor.getQueue().remainingCapacity());
                //如果队列剩余容量为零，则不能将更多元素添加到BlockingQueue。
                while (threadPoolExecutor.getQueue().remainingCapacity() == 0){
                    try {
                        TimeUnit.MILLISECONDS.sleep(4); //休眠4毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("触发自定义拒绝策略了,到这里说明已经不等于0了,又可以执行任务了"+threadPoolExecutor.getQueue().remainingCapacity());
                //runnable.run();让主线程去执行
                threadPoolExecutor.execute(runnable);//让线程池执行任务
            }
        }
    }

}