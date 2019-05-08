package per.sg.road.designpattern.creativepatterns.factorymethodpatter;

/**
 * @author : SGang
 * @Title:MultiFactoryTest
 * @Description 多工厂方法模式
 * @date : 2019/5/7
 */
public class MultiFactoryTest {
    /**
     * 多工厂方法模式
     * 扩展多个类型时 需要修改原工厂代码,但是不会动原有代码 只是新增方法 。 不太违背 --- 开闭原则
     *
     * @param args
     */
    public static void main(String[] args) {
        MultiSendFactory multiSendFactory = new MultiSendFactory();
        Sender mailSender = multiSendFactory.produceMail();
        mailSender.send();
        Sender smsSender = multiSendFactory.produceSms();
        smsSender.send();
    }
}