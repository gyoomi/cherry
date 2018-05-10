线程池类结构

画了一张图表示线程池的类结构图：



这张图基本简单代表了线程池类的结构：

1、最顶级的接口是Executor，不过Executor严格意义上来说并不是一个线程池而只是提供了一种任务如何运行的机制而已

2、ExecutorService才可以认为是真正的线程池接口，接口提供了管理线程池的方法

3、下面两个分支，AbstractExecutorService分支就是普通的线程池分支，ScheduledExecutorService是用来创建定时任务的

 

ThreadPoolExecutor六个核心参数

这篇文章重点讲的就是线程池ThreadPoolExecutor，开头也演示过ThreadPoolExecutor的使用了。

下面来看一下ThreadPoolExecutor完整构造方法的签名，签名中包含了六个参数，是ThreadPoolExecutor的核心，对这些参数的理解、配置、调优对于使用好线程池是非常重要的。因此接下来需要逐一理解每个参数的具体作用。先看一下构造方法签名：

复制代码
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler)
复制代码
1、corePoolSize

核心池的大小。在创建了线程池之后，默认情况下，线程池中没有任何线程，而是等待有任务到来才创建线程去执行任务。默认情况下，在创建了线程池之后，线程池钟的线程数为0，当有任务到来后就会创建一个线程去执行任务

2、maximumPoolSize

池中允许的最大线程数，这个参数表示了线程池中最多能创建的线程数量，当任务数量比corePoolSize大时，任务添加到workQueue，当workQueue满了，将继续创建线程以处理任务，maximumPoolSize表示的就是wordQueue满了，线程池中最多可以创建的线程数量

3、keepAliveTime

只有当线程池中的线程数大于corePoolSize时，这个参数才会起作用。当线程数大于corePoolSize时，终止前多余的空闲线程等待新任务的最长时间

4、unit

keepAliveTime时间单位

5、workQueue

存储还没来得及执行的任务

6、threadFactory

执行程序创建新线程时使用的工厂

7、handler

由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序

 

corePoolSize与maximumPoolSize举例理解

上面的内容，其他应该都相对比较好理解，只有corePoolSize和maximumPoolSize需要多思考。这里要特别再举例以四条规则解释一下这两个参数：

1、池中线程数小于corePoolSize，新任务都不排队而是直接添加新线程

2、池中线程数大于等于corePoolSize，workQueue未满，首选将新任务加入workQueue而不是添加新线程

3、池中线程数大于等于corePoolSize，workQueue已满，但是线程数小于maximumPoolSize，添加新的线程来处理被添加的任务

4、池中线程数大于大于corePoolSize，workQueue已满，并且线程数大于等于maximumPoolSize，新任务被拒绝，使用handler处理被拒绝的任务

ThreadPoolExecutor的使用很简单，前面的代码也写过例子了。通过execute(Runnable command)方法来发起一个任务的执行，通过shutDown()方法来对已经提交的任务做一个有效的关闭。尽管线程池很好，但我们要注意JDK API的一段话：

强烈建议程序员使用较为方便的Executors工厂方法Executors.newCachedThreadPool()（无界线程池，可以进行线程自动回收）、Executors.newFixedThreadPool(int)（固定大小线程池）和Executors.newSingleThreadExecutor()（单个后台线程），它们均为大多数使用场景预定义了设置。

所以，跳开对ThreadPoolExecutor的关注（还是那句话，有问题查询JDK API），重点关注一下JDK推荐的Executors。