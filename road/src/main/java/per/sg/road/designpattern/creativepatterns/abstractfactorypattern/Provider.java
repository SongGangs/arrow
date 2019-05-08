package per.sg.road.designpattern.creativepatterns.abstractfactorypattern;

import per.sg.road.designpattern.creativepatterns.factorymethodpatter.Sender;

/**
 * @author : SGang
 * @Title:Provider
 * @Description
 * @date : 2019/5/7
 */
public interface Provider {
    public Sender produce();
}