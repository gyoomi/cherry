ReentrantLock中的其他方法

篇幅原因，ReentrantLock中还有很多没有被列举到的方法就不写了，看一下它们的作用：

1、getWaitQueueLength(Condition condition)
类似getQueueLength()，不过此方法的前提是condition。比如5个线程，每个线程都执行了同一个await()的await()方法，那么方法调用的返回值是5，因为5个线程都在等待获得锁

2、hasWaiters(Condition condition)
查询是否有线程正在等待与此锁有关的condition条件。比如5个线程，每个线程都执行了同一个condition的await()方法，那么方法调用的返回值是true，因为它们都在等待condition

3、lockInterruptibly()
如果当前线程未被中断，则获取锁

4、getWaitingThreads(Condition condition)
返回一个collection，它包含可能正在等待与此锁相关给定条件的那些线程，因为构造结果的时候实际线程可能动态变化，因此返回的collection只是尽力的估计值