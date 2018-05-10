/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/10 15:38
 */
public class ExecutorsTest {

    public static void main(String[] args) {


        
    }

    /**
     * 无界线程池
     * 无界线程池，意思是不管多少任务提交进来，都直接运行。无界线程池采用了SynchronousQueue，采用这个线程池就没有workQueue容量一说了，只要添加进去的线程就会被拿去用。
     * 既然是无界线程池，那线程数肯定没上限，所以以maximumPoolSize为主了，设置为一个近似的无限大Integer.MAX_VALUE。
     *
     */
    public static void testCachedThreadPool() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(3000);
                        System.out.println("睡完了");
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    
    /**
     * 固定大小线程池
     * 固定大小的线程池和单线程的线程池异曲同工，无非是让线程池中能运行的线程编程了手动指定的nThreads罢了。同样，由于是选择了LinkedBlockingQueue，因此其实第二个参数maximumPoolSize同样也是无意义的
     *
     */
    public static void testFixedThreadPool() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
