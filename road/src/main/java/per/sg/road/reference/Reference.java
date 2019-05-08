package per.sg.road.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author : SGang
 * @Title:Reference
 * @Description 引用类型：强引用、软引用、弱引用、虚引用
 * @date : 2019/4/18
 */
public class Reference {

    //由强到弱
    private static void tset_gc1() {
        //在heap中创建内容为"reference"的对象，并建立a到该对象的强引用，此时该对象时强可及
        String a = new String("reference");
        //对heap中的对象建立软引用，此时heap中的对象仍然是强可及
        SoftReference<?> sf = new SoftReference<>(a);
        //对heap中的对象建立弱引用，此时heap中的对象仍然是强可及
        WeakReference<?> wf = new WeakReference<>(a);
        System.out.println("强引用：" + a + "\n软引用：" + sf.get() + "\n弱引用：" + wf.get());
        //heap中的对象从强可及到软可及
        a = null;
        System.out.println("强引用：" + a + "\n软引用：" + sf.get() + "\n弱引用：" + wf.get());
        //回收软引用
        sf.clear();
        System.out.println("强引用：" + a + "\n软引用：" + sf.get() + "\n弱引用：" + wf.get());
        System.gc();
        System.out.println("强引用：" + a + "\n软引用：" + sf.get() + "\n弱引用：" + wf.get());
    }

    //由弱到强
    private static void tset_gc2() {
        //在heap中创建内容为"reference"的对象，并建立a到该对象的强引用，此时该对象时强可及
        String a = new String("reference");
        //对heap中的对象建立软引用，此时heap中的对象仍然是强可及
        SoftReference<?> sf = new SoftReference<>(a);
        //对heap中的对象建立弱引用，此时heap中的对象仍然是强可及
        WeakReference<?> wf = new WeakReference<>(a);
        System.out.println("强引用：" + a + "\n软引用：" + sf.get() + "\n弱引用：" + wf.get());
        a = null;//heap中的对象从强可及到软可及
        System.out.println("强引用：" + a + "\n软引用：" + sf.get() + "\n弱引用：" + wf.get());
        //垃圾引用
        System.gc();
        System.out.println("强引用：" + a + "\n软引用：" + sf.get() + "\n弱引用：" + wf.get());
    }

    public static void main(String[] args) {
        tset_gc1();
        System.out.println("tset_gc2");
        tset_gc2();

        //以上可以看出：弱引用不能单独存活！！ 至少需要软可达。
        //虽然 WeakReference 与 SoftReference 都有利于提高 GC 和 内存的效率，
        // 但是 WeakReference ，一旦失去最后一个强引用，就会被 GC 回收，而软引用虽然不能阻止被回收，但是可以延迟到 JVM 内存不足的时候。
    }
}