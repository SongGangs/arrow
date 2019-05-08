package per.sg.road.designpattern.creativepatterns.factorymethodpatter;

/**
 * @author : SGang
 * @Title:SmsSender
 * @Description
 * @date : 2019/5/7
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("开始发送短息信息");
    }
}