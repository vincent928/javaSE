/**
 * Author : moon
 * Date  : 2018/11/7 16:07
 * Description : 线程池源码
 */
public class ExecutorsCore {

    /**
     * public static ExecutorService newFixedThreadPool(int nThreads) {
     *         return new ThreadPoolExecutor(nThreads, nThreads,
     *                                       0L, TimeUnit.MILLISECONDS,
     *                                       new LinkedBlockingQueue<Runnable>());
     *     }
     *
     *public static ExecutorService newCachedThreadPool() {
     *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     *                                       60L, TimeUnit.SECONDS,
     *                                       new SynchronousQueue<Runnable>());
     *     }
     *
     * public static ExecutorService newSingleThreadExecutor() {
     *         return new FinalizableDelegatedExecutorService
     *             (new ThreadPoolExecutor(1, 1,
     *                                     0L, TimeUnit.MILLISECONDS,
     *                                     new LinkedBlockingQueue<Runnable>()));
     *     }
     *
     */
    /**
     * ThreadPoolExecutor构造方法：
     *
     *   public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue,
     *                               ThreadFactory threadFactory,
     *                               RejectedExecutionHandler handler) {
     *         if (corePoolSize < 0 ||
     *             maximumPoolSize <= 0 ||
     *             maximumPoolSize < corePoolSize ||
     *             keepAliveTime < 0)
     *             throw new IllegalArgumentException();
     *         if (workQueue == null || threadFactory == null || handler == null)
     *             throw new NullPointerException();
     *         this.acc = System.getSecurityManager() == null ?
     *                 null :
     *                 AccessController.getContext();
     *         this.corePoolSize = corePoolSize;
     *         this.maximumPoolSize = maximumPoolSize;
     *         this.workQueue = workQueue;
     *         this.keepAliveTime = unit.toNanos(keepAliveTime);
     *         this.threadFactory = threadFactory;
     *         this.handler = handler;
     *     }
     *
     *
     *
     * corePoolSize:线程池核心线程数量
     * 1、如果池中线程数量少于核心线程池数量，则直接新建线程处理当前任务。
     * 2、核心线程池空闲不会被回收。
     * 3、当池中无空闲线程时，新任务将被添加到阻塞队列
     *
     *
     * maximumPoolSize：线程池最大线程数量
     * 1、当阻塞队列已满，并且有新任务还在入队时，创建新的线程处理，直到线程数大于maximumPoolSize。
     * 2、超出corePoolSize部分的线程超过空闲时间后会被回收
     * 3、当线程已经超出corePoolSize，并且队列容量已满，则拒绝入队。
     *
     *
     * keepAliveTime unit：线程存活时间
     * 1、当线程超出corePoolSize时生效
     * 2、线程空余keepAliveTime后，将被回收
     *
     *
     * workQueue：线程使用阻塞队列
     *
     *
     * threadFactory：创建线程池工厂
     * 1、用于控制创建线程或者销毁线程时加入其它逻辑
     *
     *
     * handler：线程池拒绝策略
     * 1、直接丢弃（DiscardPolicy）
     * 2、丢弃队列中最老的任务(DiscardOldestPolicy)。
     * 3、抛异常(AbortPolicy)
     * 4、将任务分给调用线程来执行(CallerRunsPolicy)
     *
     *
     *
     */



}
