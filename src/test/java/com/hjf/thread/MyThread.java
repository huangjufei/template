package com.hjf.thread;


/**
 * 这个段程序主要目的测试interrupt()方法,来停止线程,结果运行发现for循环永远会输完100,最初觉得
 *在InterruptedException 异常发生后使用 Thread.currentThread().interrupt()后while的判断就该不成立了,但为什么
 * 还是输出了100;后来我才发现,while其实已经不成立了,只是里面的for循环不会因为Thread.currentThread().interrupt()
 * 而退出
 *
 * 最后总结:
 * 1,在while中使用for这种嵌套要注意,while不成立时,for还是会执行完成
 * 2,Thread.currentThread().interrupt()确实可以停止while的isInterrupted()判断
 * 3,InterruptedException 进到这个异常中时,标识已经时false了
 * 4,如果在InterruptedException 中不再次使用Thread.currentThread().interrupt(),while条件永远生效,会无限循环
 * 5,beack来退出for循环,但后面的语句还会执行
 * 6,使用return退出for循环,后面的语句不会执行
 *
 */
public class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
       try {
            Thread.sleep(2000);//使开启的线程能够跑到执行体，否则线程还没到达执行体就被中断，此时判断中断状态肯定为true。
            //那么就不能跑到执行体里面了
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程中断开启线程" + t.currentThread().isInterrupted());
        t.interrupt();//主线程中断开启线程

        System.out.println("等待中断请求" + t.currentThread().isInterrupted());
        try {
            Thread.sleep(3000);//等待开启线程处理中断
        } catch (InterruptedException e) {
            System.out.println("2222222222222");
            e.printStackTrace();
        }
        System.out.println("应用程序结束");
    }


    public void run() {
        while (!this.isInterrupted()) {
            System.out.println("线程正在运行。。");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("开启线程被中断" + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();//对中断请求的处理就是中断自己,如果屏蔽它while条件永远成立,死循环
                    System.out.println("开启线程被中断--后" + Thread.currentThread().isInterrupted());
                    // break;//跳出for循环,但for循环后还是会执行
                    //return;//让for循环外的代码不被执行
                }
                System.out.println("i的值为：" + i + " " + Thread.currentThread().isInterrupted());
            }
            System.out.println("for循环后的代码");
        }
    }
}