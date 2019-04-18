package per.sg.road.multithreading;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author : SGang
 * @Title:ThreadPool
 * @Description
 * @date : 2019/4/16
 */
public class ThreadPool {
    private final static int corePoolSize = 5;
    private final static int maximumPoolSize = 10;
    private final static long keepAliveTime = 0L;
    private final static TimeUnit unit = TimeUnit.MILLISECONDS;
    private final static BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(1024);
    private static ThreadFactory threadFactory = null;
    private static RejectedExecutionHandler handler = null;

    public ThreadPool() {
        threadFactory = new ThreadFactoryBuilder().setNameFormat("name-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                unit, workQueue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();
    }

    public static void main(String[] args) {
    }
}