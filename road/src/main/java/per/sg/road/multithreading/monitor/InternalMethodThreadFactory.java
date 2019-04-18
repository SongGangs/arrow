package per.sg.road.multithreading.monitor;

/**
 * @author : SGang
 * @Title:InternalMethodThreadFactory
 * @Description
 * @date : 2019/4/12
 */
public class InternalMethodThreadFactory {

    public static void produce() {
        System.out.println("ProducerThread");
        for (int i = 0; i < 10; i++) {
            ProducerThread thread = new ProducerThread();
            thread.run();
        }
    }

    public static void consume() {
        System.out.println("ConsumerThread");
        for (int i = 0; i < 10; i++) {
            ConsumerThread thread = new ConsumerThread();
            thread.run();
        }
    }


    public static void main(String[] args) {
        InternalMethodThreadFactory.consume();
        InternalMethodThreadFactory.produce();
        InternalMethodThreadFactory.consume();
    }


}