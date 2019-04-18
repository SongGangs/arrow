package per.sg.road.multithreading.monitor;

/**
 * @author : SGang
 * @Title:ConsumerThread
 * @Description
 * @date : 2019/4/12
 */
public class ConsumerThread extends Thread {

    @Override
    public void run() {
        InternalMethod method = new InternalMethod();
        method.consume();
    }

}