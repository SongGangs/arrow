package per.sg.road.designpattern.creativepatterns.factorymethodpattern;

/**
 * @author : SGang
 * @Title:StaticSendFactory
 * @Description 静态工厂方法模式
 * @date : 2019/5/7
 */
public class StaticSendFactory {
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }
}