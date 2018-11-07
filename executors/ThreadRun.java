import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Author : moon
 * Date  : 2018/11/7 15:53
 * Description : Class for
 */
public class ThreadRun implements Runnable {

    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SS");

    private Integer num;

    public ThreadRun(Integer num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Thread:" + Thread.currentThread().getName() + ",time:" + format.format(new Date()) + ",num:" + num);
        try {//使线程阻塞，模拟线程阻塞情况
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
