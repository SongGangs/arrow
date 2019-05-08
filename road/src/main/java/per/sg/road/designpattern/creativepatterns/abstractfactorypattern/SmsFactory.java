package per.sg.road.designpattern.creativepatterns.abstractfactorypattern;

import per.sg.road.designpattern.creativepatterns.factorymethodpatter.Sender;
import per.sg.road.designpattern.creativepatterns.factorymethodpatter.SmsSender;

/**
 * @author : SGang
 * @Title:SmsFactory
 * @Description
 * @date : 2019/5/7
 */
public class SmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}