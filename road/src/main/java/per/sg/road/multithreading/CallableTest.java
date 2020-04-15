package per.sg.road.multithreading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * @ClassName CallableTest
 * @Description Callable+Future
 * @Author childs
 * @Date 2020-04-10 18:28
 * @Version 1.0
 **/
public class CallableTest {

    public static String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("mm:ss"));
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("子线程在进行计算");
                Thread.sleep(3000);
                int sum = 0;
                for (int i = 0; i < 100; i++)
                    sum += i;
                return sum;
            }
        };
        Future result = executor.submit(callable);
        executor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");

    }
}
