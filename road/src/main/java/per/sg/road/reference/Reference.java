package per.sg.road.reference;

import java.lang.ref.SoftReference;

/**
 * @author : SGang
 * @Title:Reference
 * @Description 引用类型：强引用、软引用、弱引用、虚引用
 * @date : 2019/4/18
 */
public class Reference {
    public static void main(String[] args){
        String a="test";//强引用
        SoftReference<String> sf=new SoftReference<>(a);
    }
}