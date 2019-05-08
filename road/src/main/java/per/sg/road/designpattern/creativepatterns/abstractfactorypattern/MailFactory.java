package per.sg.road.designpattern.creativepatterns.abstractfactorypattern;

import per.sg.road.designpattern.creativepatterns.factorymethodpatter.MailSender;
import per.sg.road.designpattern.creativepatterns.factorymethodpatter.Sender;

/**
 * @author : SGang
 * @Title:MailFactory
 * @Description
 * @date : 2019/5/7
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}