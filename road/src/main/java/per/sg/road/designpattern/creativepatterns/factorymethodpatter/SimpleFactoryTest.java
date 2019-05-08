package per.sg.road.designpattern.creativepatterns.factorymethodpatter;

/**
 * @author : SGang
 * @Title:FactoryTest
 * @Description 检验工厂方法模式
 * @date : 2019/5/7
 */
public class SimpleFactoryTest {

    /**
     * 简单工厂方法模式 测试
     * 这种模式 需要外部输入指定 参数  容易出现输入错误。
     * 扩展多个类型时 需要修改原工厂代码。 违背 --- 开闭原则
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleSendFactory simpleSendFactory = new SimpleSendFactory();
        //短息
        Sender sms = simpleSendFactory.produce("sms");
        sms.send();
        //邮件
        Sender mail = simpleSendFactory.produce("mail");
        mail.send();
        //错误类型
        Sender fail = simpleSendFactory.produce("mails");
        fail.send();
    }
}