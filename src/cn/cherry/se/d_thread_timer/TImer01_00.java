/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_timer;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * schedule()
 * 该方法的作用是在执行的日期执行一次任务
 *    1.执行任务的时间晚于当前时间：未来执行
 *    2.划时间早于当前时间：立即执行
 *    3.多个TimerTask任务执行
 *
 * @author Leon
 * @version 2018/5/10 17:02
 */
public class TImer01_00 {

    private static Timer timer = new Timer(true);

    static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了...Time = " + new Date().toLocaleString());
        }
    }

    public static void main(String[] args) {
        try {
            Date toExecuteDate = DateUtils.parseDate("2018-05-10 17:24:00", "yyyy-MM-dd HH:mm:ss");
            MyTask task = new MyTask();
            System.out.println("计划时间：2018-05-10 17:24:00， 当前日期：" + new Date().toLocaleString());
            timer.schedule(task,toExecuteDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
