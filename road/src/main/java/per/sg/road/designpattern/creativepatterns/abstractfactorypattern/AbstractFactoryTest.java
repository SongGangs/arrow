package per.sg.road.designpattern.creativepatterns.abstractfactorypattern;

import per.sg.road.designpattern.creativepatterns.factorymethodpattern.Sender;

/**
 * @author : SGang
 * @Title:AbstractFactoryTest
 * @Description 抽象工厂模式
 * @date : 2019/5/7
 */
public class AbstractFactoryTest {

    /**
     * 抽象工厂模式
     * 完全遵守 闭包原则
     *
     * @param args
     */
    public static void main(String[] args) {
        Provider mailFactory = new MailFactory();
        Sender mailSender = mailFactory.produce();
        mailSender.send();
        Provider smsFactory = new SmsFactory();
        Sender smsSender = smsFactory.produce();
        smsSender.send();
    }
}