package per.sg.road.designpattern.creativepatterns.prototypepattern;

import java.io.IOException;

/**
 * @author : SGang
 * @Title:PrototypeTest
 * @Description
 * @date : 2019/5/8
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        String string = "string";
        SerializableObject serializableObject = new SerializableObject();
        Prototype prototype = new Prototype();
        prototype.setSerializableObject(serializableObject);
        prototype.setString(string);
        //浅复制
        Prototype shallow = prototype.shallowClone();
        System.out.println("shallow：" + (shallow == prototype));
        System.out.println("shallow：" + (shallow.getString() == prototype.getString()));
        System.out.println("shallow：" + (shallow.getSerializableObject() == prototype.getSerializableObject()));

        //深复制
        Prototype deep = prototype.deepClone();
        System.out.println("deep：" + (deep == prototype));
        System.out.println("deep：" + (deep.getString() == prototype.getString()));
        System.out.println("deep：" + (deep.getSerializableObject() == prototype.getSerializableObject()));

        //
        System.out.println("compare：" + (deep == shallow));
        System.out.println("compare：" + (deep.getString() == shallow.getString()));
        System.out.println("compare：" + (deep.getSerializableObject() == shallow.getSerializableObject()));
    }
}