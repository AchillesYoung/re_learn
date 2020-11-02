package Singleton;

public class SingletonDemo extends Thread {
    private int i = 0;

    @Override
    public void run() {
        //同一个类的不同实例hashcode不同
        System.out.println(Hungary.getInstance().hashCode() + "Hungary");
        System.out.println(Lazy.getInstance().hashCode() + " ");
        System.out.println("******" + i + "*******");
        ++i;
    }

    public static void main(String[] args) {
        SingletonDemo[] arrs = new SingletonDemo[5];
//        SingletonHungary s2 = SingletonHungary.getInstance();
        for (int i = 0; i < 5; i++) {
            arrs[i] = new SingletonDemo();
        }
        for (int i = 0; i < 5; i++) {
            arrs[i].start();
        }
    }
}

/**
 * 需要理解static修饰的类
 * 1. 饿汉模式:类加载到内存，就实例化一次单例，jvm保证有效避免了线程安全问题
 * 缺点：
 * 不管是否用到，对象定义为static变量。程序启动即将其构造完成了，可能化浪费内存，或者减慢启动速度。
 * 有人说可以把它class.forName加载入内存，但是不实例化（但是你如果不实例化，装载做什么）？->所以不考虑
 */

class Hungary {
    //如果不加final，会可能被人为用反射机制给覆盖掉，加了final不可能被改掉
    private static final Hungary instance = new Hungary();

    private Hungary() {

    }

    public static Hungary getInstance() {


        return instance;
    }
}

class Hungary2 {
    private static final Hungary2 instance;

    static {
        instance = new Hungary2();
    }

    private Hungary2() {
    }

    public static Hungary2 getInstance() {
        return instance;
    }
}

/**
 * 饿汉方式不论是否需要使用该对象都将其定义出来，可能浪费了内存，或者减慢了程序的启动速度。
 * 所以使用懒汉模式进行优化，懒汉模式即延迟构造对象，在第一次使用该对象的时候才进行new该对象
 * 出现了线程问题
 * 最出名的解决方案就是Double-Checked Locking Pattern (DCLP)。使用两次判断来解决线程安全问题并且提高效率。
 * 问题2，两个线程如果同时进去怎么办
 * 多线程枷锁
 */

class Lazy {
    /**
     * 这里懒汉不能加final，因为final的变量必须初始化
     * 而且这个变量最好加上volatile，因为java底层（汇编语言）会指令重排序，会出现初始化cpu碎片颠倒顺序
     */
    private static volatile Lazy instance;

    //    private static Object syncLock = new Object();
    private Lazy() {

    }

    /**
     * 存在问题：线程问题复杂还需要优化
     *
     * @return
     */
    public static Lazy getInstance() {
        //这里我们双重判断，在等锁之前判断：避免很多线程在等锁等待，
        if (null == instance) {
            //这是是锁了同步代码块，因为如果锁整个方法会锁到整个类(生产中的类内存比较大)，这样会降低效率
            synchronized (Lazy.class) {

                if (null == instance) {
                    try {
                        //为了更容易看到加锁的效果
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Lazy();
                }

            }
        }
        return instance;
    }

}
