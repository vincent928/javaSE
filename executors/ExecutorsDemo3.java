import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author : moon
 * Date  : 2018/11/7 15:59
 * Description : Class for
 */
public class ExecutorsDemo3 {

    /**
     * ScheduledThreadPool
     * 创建一个定长线程池，支持定时及周期性任务执行
     */
    public static void main(String[] agrs) {
        ExecutorService ex = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 50; i++) {
            //延时3秒执行
            ((ScheduledExecutorService) ex).schedule(new ThreadRun(i + 1), 3, TimeUnit.SECONDS);
            //延迟1秒后，每3秒执行一次
//            ((ScheduledExecutorService) ex).scheduleAtFixedRate(new Runnable() {
//                public void run() {
//                    System.out.println("Thread:" + Thread.currentThread().getName() + ",Time:" + new SimpleDateFormat("HH:ss:mm:SS").format(new Date()));
//                }
//            }, 1, 3, TimeUnit.SECONDS);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        ex.shutdown();
    }
}
