package per.sg.road.designpattern.creativepatterns.factorymethodpattern;

/**
 * @author : SGang
 * @Title:MultiSendFactory
 * @Description 多工厂方法模式
 * @date : 2019/5/7
 */
public class MultiSendFactory {

    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }
}