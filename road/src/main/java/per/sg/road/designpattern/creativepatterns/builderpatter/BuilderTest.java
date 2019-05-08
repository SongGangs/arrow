package per.sg.road.designpattern.creativepatterns.builderpatter;

/**
 * @author : SGang
 * @Title:BuilderTest
 * @Description 建造者模式
 * @date : 2019/5/7
 */
public class BuilderTest {

    /**
     * 建造者模式 与 工厂模式相似 但是两者关注点不同
     * 建造者模式 关注的是一条产品线
     * 工厂模式 关注的是某一个特定产品整体
     *
     * @param args
     */
    public static void main(String[] args) {
        Builder mailBuilder = new Builder();
        mailBuilder.produceMailList(10);
        mailBuilder.send();


        Builder smsBuilder = new Builder();
        smsBuilder.produceSmsList(10);
        smsBuilder.send();
    }
}