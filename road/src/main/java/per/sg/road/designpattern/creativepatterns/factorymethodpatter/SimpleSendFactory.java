package per.sg.road.designpattern.creativepatterns.factorymethodpatter;

/**
 * @author : SGang
 * @Title:SenderFactory
 * @Description  普通工厂方法模式
 * @date : 2019/5/7
 */
public class SimpleSendFactory {

    public Sender produce(String type) {
        Sender sender = null;
        switch (type) {
            case "sms":
                sender = new SmsSender();
                break;
            case "mail":
                sender = new MailSender();
                break;
            default:
                System.out.println("消息类型不存在");
                break;
        }
        return sender;
    }

}