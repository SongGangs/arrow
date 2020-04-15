package per.sg.road.multithreading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTest
 * @Description 信号量
 * @Author childs
 * @Date 2020-04-10 18:22
 * @Version 1.0
 **/
public class SemaphoreTest {
    /**
     * 线程池是控制线程的数量，信号量是控制共享资源的并发访问量
     * 公共厕所的蹲位……，10人等待5个蹲位的测试，满员后就只能出一个进一个
     */
    private static final int NUMBER = 5;    //限制资源访问数
    private static final Semaphore avialable = new Semaphore(NUMBER, true);

    public static String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("mm:ss"));
    }

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    avialable.acquire(); //此方法阻塞等待
                    Thread.sleep(10 * 1000);
                    System.out.println(getNow() + "--" + Thread.currentThread().getName() + "--执行完毕");
                    avialable.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println(avialable.availablePermits());
        for (int i = 0; i < 10; i++) {
            pool.execute(r);
        }
        System.out.println(avialable.availablePermits());
        pool.shutdown();
    }
}
