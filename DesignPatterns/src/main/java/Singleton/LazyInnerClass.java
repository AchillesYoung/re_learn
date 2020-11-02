package Singleton;

/**
 * 更完美的写法，内部静态类。
 * 饿汉，会在加载的时候初始化静态
 * 饿汉内部类
 * 你如果不用它，静态内部类不会被加载，只有在getInstance的时候用到它了才会被加载
 */
public class LazyInnerClass {
    private LazyInnerClass() {

        if(InnerLazy.INSTANCE != null){
            throw new RuntimeException("no allowable to create");
        }

    }
    /**
     * jvm的机制保证内部类只加载一次单例，所以即实现了懒加载，也实现了单例
     * InnerLazy内部类中的逻辑，需要被外部调用才可以加载
     */
    private static class InnerLazy {
        private final static LazyInnerClass INSTANCE = new LazyInnerClass();
    }

    public static LazyInnerClass getInstance() {
        return InnerLazy.INSTANCE;
    }


}
