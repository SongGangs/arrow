package per.sg.road.multithreading.monitor;

/**
 * @author : SGang
 * @Title:InternalMethodThread
 * @Description
 * @date : 2019/4/12
 */
public class ProducerThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            InternalMethod method = new InternalMethod();
            method.produce();
        }
    }
}