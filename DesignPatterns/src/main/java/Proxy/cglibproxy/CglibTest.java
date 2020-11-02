package Proxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 */
public class CglibTest {
    public static void main(String[] args) {

        try {
            /**
             * JDK是读取实现的接口信息，
             * 被代理类必须有接口实现相对来说复杂，生成新的类逻辑简单，执行效率相对低，每次都要反射调用
             */

            /**
             * Cglib是继承了被代理类，覆盖重写了父类方法（可以代理任何普通类）
             * 生成一个新的类（实际有三个类文件有一个包含了所有的逻辑的FastClass，
             * 不需要反射去调用特定方法了，细节反编译也看不太出来，目前不必要研究
             * CGLib 生成代理逻辑更复杂，效率,调用效率更高，生成一个包含了所有的逻辑的FastClass，不再需要反射调用
             * CGLib 有个坑，CGLib不能代理final的方法，因为final方法无法重写覆盖
             */

            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/shuyang/JavaWeb/spring-learn");
            //cglibproxy.Customer$$EnhancerByCGLIB$$6397c1f8@2d8e6db6
            Customer instance = (Customer) new CglibProxy().getInstance(Customer.class);
            //Customer是父类
            System.out.println(instance);
            instance.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
