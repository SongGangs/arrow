package per.sg.road.designpattern.creativepatterns.factorymethodpatter;

/**
 * @author : SGang
 * @Title:MailSender
 * @Description
 * @date : 2019/5/7
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("开始发送邮件消息");
    }
    
}