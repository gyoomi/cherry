1、第1行~第23行。这块BlockingQueue未满，所以生产者随便生产，消费者随便消费，基本上都是生产3个消费1个，消费者消费速度慢
2、第24行~第27行，从前面我们可以看出，生产到16，消费到6，说明到了ArrayBlockingQueue的极限10了，这时候没办法，生产者生产一个ArrayBlockingQueue就满了，所以不能继续生产了，只有等到消费者消费完才可以继续生产。所以之后的打印内容一定是一个生产者、一个消费者

这就是前面一章开头说的"通过平衡生产者和消费者的处理能力来提高整体处理数据的速度"，这给例子应该体现得很明显。另外，也不要担心非单一生产者/消费者场景下的系统假死问题，缓冲区空、缓冲区满的场景BlockingQueue都是定义了不同的Condition，所以不会唤醒自己的同类。