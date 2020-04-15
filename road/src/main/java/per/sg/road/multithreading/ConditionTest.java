package per.sg.road.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionTest
 * @Description Condition ReentrantLock 可重入锁
 * @Author childs
 * @Date 2020-04-11 14:29
 * @Version 1.0
 **/
public class ConditionTest {
    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final Condition CONDITION = LOCK.newCondition();

    private static int count = 1;

    static Object lock = new Object();

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                LOCK.lock();
                try {
                    if (count <= 5) {
                        System.out.println("----r1---");
                        System.out.println(Thread.currentThread().getName() + "--" + count++);
                        Thread.sleep(1000);
                    }
                    CONDITION.signal();        //线程r1释放条件信号，以唤醒r2中处于await的代码继续执行。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                LOCK.lock();
                try {
                    if (count <= 5) {
                        System.out.println("----$$$---");
                        CONDITION.await();    //但调用await()后，lock锁会被释放，让线程r1能获取到，与Object.wait()方法一样
                        System.out.println("----------");
                    }
                    while (count <= 10) {
                        System.out.println(Thread.currentThread().getName() + "--" + count++);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            }
        };

        System.out.println("111111111111");
        new Thread(r2).start();    //让r2先执行，先获得lock锁，但条件不满足，让r2等待await。
        try {
            Thread.sleep(100);    //这里休眠主要是用于测试r2.await()会释放lock锁，被r1获取
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2222222");
        new Thread(r1).start();
    }
}
