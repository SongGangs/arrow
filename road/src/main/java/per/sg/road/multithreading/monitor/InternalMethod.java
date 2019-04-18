package per.sg.road.multithreading.monitor;

/**
 * @author : SGang
 * @Title:InternalMethod
 * @Description synchronized, wait, notify结合:典型场景生产者消费者问题
 * @date : 2019/4/12
 */
public class InternalMethod {

    private final static int MAX_PRODUCT = 10;

    private volatile int product = 0;

    public synchronized void produce() {
        if (product >= MAX_PRODUCT) {
            try {
                wait();
                System.out.println("产品库库存已满，无法继续生产。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        product++;
        System.out.println("生产者生产第" + product + "个产品");
        //通知等待区的消费者可以取出产品了
        notifyAll();
    }

    public synchronized void consume() {
        if (product <= 0) {
            try {
                wait();
                System.out.println("产品库暂无可用产品，请等待生产。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        product--;
        System.out.println("消费者消费第" + product + "个产品");
        //通知等待区的生产者可以生产产品了
        notifyAll();
    }

}