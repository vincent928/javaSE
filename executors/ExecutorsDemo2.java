import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author : moon
 * Date  : 2018/11/7 15:53
 * Description : Class for
 */
public class ExecutorsDemo2 {

    /**
     * newFixedThreadPool
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     *
     * - 池中线程数量固定，不会发生变化
     * - 使用无界的LinkedBlockingQueue，要综合考虑生成与消费能力，生成过剩，可能导致堆内存溢出。
     * - 适用一些很稳定很固定的正规并发线程，多用于服务器
     */
    public static void main(String[] agrs) {
        ExecutorService ex = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 50; i++) {
            ex.submit(new ThreadRun(i+1));
        }
        ex.shutdown();
    }
}
