import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author : moon
 * Date  : 2018/11/7 15:45
 * Description : Class for
 */

/**
 * Java通过Executors提供四种线程池，分别为：
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class ExecutorsDemo1 {


    /**
     * newCachedThreadPool
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     * - 池中线程时随着处理数据增加而增加
     * - 线程数并不是一直增加，如果有新任务需要执行时，首先查询池中是否有空闲线程并且还为到空闲截止时间，如果有，则使用空闲线程，如果没有，则创建新线程并放入池中。
     * - 用于执行一些生存期很短的异步型任务。不适用于IO等长延时操作，因为这可能会创建大量线程，导致系统崩溃。
     * - 使用SynchronousQueue作为阻塞队列，如果有新任务进入队列，必须队列中数据被其他线程处理，否则会等待。
     */
    public static void main(String[] agrs) {

        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
                ex.submit(new ThreadRun(i+1));
        }
        ex.shutdown();

    }


}
