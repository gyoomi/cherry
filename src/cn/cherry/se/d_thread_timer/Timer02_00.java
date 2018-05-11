/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_timer;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/11 9:28
 */
public class Timer02_00 {

    private static Timer timer = new Timer();

    static class TimeTaskA extends TimerTask {

        @Override
        public void run() {
            System.out.println("A任务执行了：" + new Date().toLocaleString());
            // TimerTask的cancel()方法的作用是将自身从任务队列中清除,其他任务不受影响
            // this.cancel();
            timer.cancel();
        }
    }

    static class TimeTaskB extends TimerTask {

        @Override
        public void run() {
            System.out.println("B任务执行了：" + new Date().toLocaleString());
        }
    }

    public static void main(String[] args) throws Exception {
        test02();
    }

    /**
     * Timer的cancel()方法
     * 1.全部任务都被清除，并且进程被销毁。
     * 2.不过注意一下，cancel()方法未必一定会停止执行计划任务，可能正常执行，因为cancel()方法会尝试去获取queue锁，如果并没有获取到queue锁的话，TimerTask类中的任务继续执行也是完全有可能的
     *
     */
    public static void test02() throws Exception {
        TimeTaskA taskA = new TimeTaskA();
        TimeTaskB taskB = new TimeTaskB();
        String toExecuteString = "2018-05-11 09:40:00";
        Date toExecuteDate = DateUtils.parseDate(toExecuteString, "yyyy-MM-dd HH:mm:ss");
        System.out.println("计划时间："+ toExecuteString +"， 当前日期：" + new Date().toLocaleString());
        timer.schedule(taskA, toExecuteDate, 3000);
        timer.schedule(taskB, toExecuteDate, 3000);
    }

    /**
     * TimerTask的cancel()方法
     * 1.TimerTask的cancel()方法的作用是将自身从任务队列中清除,其他任务不受影响
     *
     * @throws Exception
     */
    public static void test01() throws Exception{
        TimeTaskA taskA = new TimeTaskA();
        TimeTaskB taskB = new TimeTaskB();
        String toExecuteString = "2018-05-11 09:37:00";
        Date toExecuteDate = DateUtils.parseDate(toExecuteString, "yyyy-MM-dd HH:mm:ss");
        System.out.println("计划时间："+ toExecuteString +"， 当前日期：" + new Date().toLocaleString());
        timer.schedule(taskA, toExecuteDate, 3000);
        timer.schedule(taskB, toExecuteDate, 3000);
    }
}
