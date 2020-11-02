package Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO
 * 反射访问代码
 */
public class BreakSingleton {
    public static void main(String[] args) {
        Class<?> clazz = LazyInnerClass.class;
        try {
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance();
            Object o1 = LazyInnerClass.getInstance();
            //反射机制破坏了单例的
            /**
             * 应对策略，在构造方法中加判断
             */
            System.out.println(o == o1);//RuntimeException: no allowable to create
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(SingletonEnum.INSTANCE.hashCode());
            }).start();
        }
    }
}
