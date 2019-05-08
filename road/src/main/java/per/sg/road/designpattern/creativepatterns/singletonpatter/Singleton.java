package per.sg.road.designpattern.creativepatterns.singletonpatter;

/**
 * @author : SGang
 * @Title:Singleton
 * @Description 单例模式
 * @date : 2019/5/7
 */
public class Singleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton instance = null;

    /**
     * 构造方法私有化 保证示例只能被实例化一次
     */
    private Singleton() {

    }

    /**
     * 实例化对象 但存在多线程不安全
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 实例化对象 多线程安全
     * 每次调用getInstance()，都要对对象上锁
     * 方法体加锁 但是加锁 影响性能
     *
     * @return
     */
    public static synchronized Singleton getInstance2() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 实例化对象 多线程安全
     * 只有在instance为null，并创建对象的时候才需要加锁，性能有一定的提升
     * 但是多线程进来时
     * a: A、B同时进入第一个IF判断
     * b. A先进入synchronized块 这是instance为null 所以new对象
     * c: 由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块
     * d: B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
     * e: 此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
     *
     * @return
     */
    public static Singleton getInstance3() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    /**
     * 此处使用一个内部类来维护单例
     * JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
     */
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance4() {
        return SingletonFactory.instance;
    }

    public Object readResolve() {
        return getInstance();
    }
}