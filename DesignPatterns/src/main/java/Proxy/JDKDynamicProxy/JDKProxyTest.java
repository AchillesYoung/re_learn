package Proxy.JDKDynamicProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/10/30-10:00 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        //我们这样调是gdk内部帮我生成了一个新的对象去加强方法$Proxy0.findLOve()
        JDKProxy jdkProxy = new JDKProxy();
        Person person = (Person)jdkProxy.getInstance(new Customer());
        //proxy:class com.self.edu.....Proxy.JDKDynamicProxy.$Proxy0
        //这里的Person已经不是customer了，是一个实现了person接口的新类$Proxy0（jdk自己生成的）
        System.out.println("proxy:"+person.getClass());
        //proxy:class com.self.edu.....Proxy.JDKDynamicProxy.Customer
        System.out.println("Customer:"+new Customer().getClass());

        person.findLove();
        person.marry();
        System.out.println("--------");

        Person instance =(Person) jdkProxy.getInstance((new Customer()));
        try {
            Method findLOve = instance.getClass().getMethod("findLOve", null);
            findLOve.invoke(instance);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
