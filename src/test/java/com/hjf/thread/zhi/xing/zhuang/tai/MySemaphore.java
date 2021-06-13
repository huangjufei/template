package com.hjf.thread.zhi.xing.zhuang.tai;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 判断线程池中的线程是否全部执行完毕,代码来源
 * https://www.cnblogs.com/stonefeng/p/5967451.html
 *
 * 执行流程:
 * 1,for循环每一次都会提交执行,只有for循环全部结束后才会到达 exec.shutdown();
 * 2,一个死循环(间隔1秒)关闭流
 *
 * 发现:
 * 1,一个写入流引用可以被多个线程使用
 * 2,信号量可以控制并发线程数,单个信号量可以实现互斥锁的功能
 * 3,可以通过这段程序测试电脑性能:家里台式12秒
 *
 * 总结:
 * 真是一段漂亮的代码,有线程池,有关闭线程,有判断线程是否执行完毕后关闭流,有控制线程并发数量
 *
 * 理解Semaphore及其用法详解
 * https://blog.csdn.net/u013851082/article/details/70208246
 */
public class MySemaphore {

    public static void main(String[] args) throws IOException, InterruptedException {
        final File stream = new File("c:\\Temp\\stream.txt");
        final OutputStream os = new FileOutputStream(stream);
        final OutputStreamWriter writer = new OutputStreamWriter(os);

        //信号量,这里指并发数量不能大于20
        final Semaphore semaphore = new Semaphore(20);
        //线程池,如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
        ExecutorService exec = Executors.newCachedThreadPool();

        final long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            final int num = i;

            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//获取许可前一直被阻塞
                        //这中间就是放执行的业务逻辑,一个写入流可以被多个线程执行
                        writer.write(Thread.currentThread().getName()+" "+String.valueOf(num)+"\n");
                        semaphore.release();//释放许可
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            //循环一次,就会提交执行
            exec.submit(task);
        }

        //for循环结束后才会到这里,然后就是关闭线程池;不在接受新任务,所有线程执行完毕后才关闭线程
        exec.shutdown();

        //一个死循环判断线程全部结束后关闭字符流
        while(true){
            //线程是否执行完成
            if(exec.isTerminated()){
                writer.write("---END---\n");
                writer.close();
                System.out.println("所有的子线程都结束了！");
                break;
            }
            Thread.sleep(1000);
        }
        final long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }
}