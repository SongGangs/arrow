package per.sg.road.designpattern.creativepatterns.factorymethodpattern;

/**
 * @author : SGang
 * @Title:StaticFactoryTest
 * @Description 静态工厂方法模式
 * @date : 2019/5/7
 */
public class StaticFactoryTest {
    /**
     * 静态工厂方法模式
     * 相比其余两种工厂方法模式 该模式 节约堆空间
     * 程序加载时 首先初始化静态类 提高效率
     *
     * @param args
     */
    public static void main(String[] args) {
        Sender mailSender = StaticSendFactory.produceMail();
        mailSender.send();
        Sender smsSender = StaticSendFactory.produceSms();
        smsSender.send();
    }
}