package com.hjf;

import java.util.concurrent.*;

public class F {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        // demo1
        FutureTask ft = new FutureTask<>(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("loading data from database...");
                Thread.sleep(1000 * 5);
                return "ok";
            }
        });


        executor.submit(ft);
        System.out.printf("Finished.Result:%s\r\n", ft.get());
        System.out.println("Run again.");
        // 之前已经运行好了，这个run就直接返回
        executor.submit(ft);
        System.out.println("Finished result:" + ft.get());

    }


}
