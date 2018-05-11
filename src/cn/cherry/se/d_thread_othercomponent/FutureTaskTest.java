/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_othercomponent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Callable+FutureTask
 *
 * @author Leon
 * @version 2018/5/11 15:16
 */
public class FutureTaskTest {

    static class CallableFutureTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("进入CallableThread的call()方法，开始睡觉，睡觉时间为：" + System.currentTimeMillis());
            Thread.sleep(10000);
            return "111";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        CallableFutureTask cft = new CallableFutureTask();
        FutureTask<String> f = new FutureTask<>(cft);
        es.submit(f);
        es.shutdown();
        Thread.sleep(5000);
        System.out.println("主线程等待5秒，当前Time = " + System.currentTimeMillis());
        String str = f.get();
        System.out.println("Future已拿到数据，str = " + str + " 当前时间为：" + System.currentTimeMillis());
    }
}
