package per.sg.road.multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName CompletionServiceTest
 * @Description 保存一组异步求解的任务结果集
 * @Author childs
 * @Date 2020-04-11 15:55
 * @Version 1.0
 **/
public class CompletionServiceTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(8);        //需要2s，如果将8改成10，则只需要1s
        CompletionService<Boolean> cs = new ExecutorCompletionService<Boolean>(pool);
        Callable<Boolean> task = new Callable<Boolean>() {
            public Boolean call() {
                try {
                    Thread.sleep(1000);
                    System.out.println("插入1000条数据完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return new Random().nextBoolean();
            }

            ;
        };
        System.out.println(getNow() + "--开始插入数据");
        for (int i = 0; i < 10; i++) {
            cs.submit(task);
        }
        for (int i = 0; i < 10; i++) {
            try {
                //ExecutorCompletionService.take()方法是阻塞的，如果当前没有完成的任务则阻塞
                System.out.println(cs.take().get());
                //实际使用时，take()方法获取的结果可用于处理，如果插入失败，则可以进行重试或记录等操作
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getNow() + "--插入数据完成");
        pool.shutdown();
    }

    public static String getNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        return sdf.format(new Date());
    }
}
