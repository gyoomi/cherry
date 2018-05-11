其他方法

再列举一些Timer中的其他schedule的重载方法的作用，就不提供证明的代码了，可以自己尝试一下：

1、schedule(TimerTask task, long delay)

以当前时间为参考，在此时间基础上延迟指定的毫秒数后执行一次TimerTask任务

2、schedule(TimerTask task, long delay, long period)

以当前时间为参考，在此时间基础上延迟指定的毫秒数后，以period为循环周期，循环执行TimerTask任务

3、scheduleAtFixedRate(TimerTask task, Date firstTime, long period)

在延时的场景下，schedule方法和scheduleAtFixedRate方法没有区别，它们的区别只是在非延时上。如果执行任务的时间没有被延时，对于schedule方法来说，下一次任务执行的时间参考的是上一次任务的开始时间来计算的；对于scheduleAtFixedRate方法来说，下一次任务执行的时间参考的是上一次任务的结束时间来计算的