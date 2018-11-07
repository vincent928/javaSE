import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author : moon
 * Date  : 2018/11/7 16:04
 * Description : Class for
 */
public class ExecutorsDemo4 {

    /**
     * SingleThreadExecutor
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     * <p>
     * - 线程中只有一个线程在执行
     * - 适用于有明确执行顺序但是不影响主线程的任务，压入池中的任务会按照队列顺序执行。
     * - 使用无界的LinkedBlockingQueue，要综合考虑生成与消费能力，生成过剩，可能导致堆内存溢出。
     */
    public static void main(String[] agrs) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 50; i++) {
            ex.submit(new ThreadRun(i + 1));
        }
        ex.shutdown();
    }
}
