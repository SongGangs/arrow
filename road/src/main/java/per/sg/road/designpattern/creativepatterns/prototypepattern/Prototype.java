package per.sg.road.designpattern.creativepatterns.prototypepattern;

import lombok.Data;

import java.io.*;

/**
 * @author : SGang
 * @Title:DeepthPrototype
 * @Description
 * @date : 2019/5/8
 */
@Data
public class Prototype implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String string;
    private SerializableObject serializableObject;

    /**
     * 浅复制
     * 基本类型会重新创建变量  但是引用类型不会重新创建
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Prototype shallowClone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    /**
     * 深复制
     * 对象所有内容都会重新创建
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Prototype deepClone() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Prototype) ois.readObject();

    }
}