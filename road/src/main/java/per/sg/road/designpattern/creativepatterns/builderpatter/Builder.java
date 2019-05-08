package per.sg.road.designpattern.creativepatterns.builderpatter;

import per.sg.road.designpattern.creativepatterns.factorymethodpatter.MailSender;
import per.sg.road.designpattern.creativepatterns.factorymethodpatter.Sender;
import per.sg.road.designpattern.creativepatterns.factorymethodpatter.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : SGang
 * @Title:Builder
 * @Description 建造者模式
 * @date : 2019/5/7
 */
public class Builder {
    private List<Sender> list = new ArrayList<>();

    public void produceMailList(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsList(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public void send() {
        for (Sender sender : list) {
            sender.send();
        }
    }
}