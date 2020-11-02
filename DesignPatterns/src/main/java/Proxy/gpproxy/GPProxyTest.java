package Proxy.gpproxy;

import com.self.edu.springlearn.DesignPattern.Proxy.JDKDynamicProxy.Customer;
import com.self.edu.springlearn.DesignPattern.Proxy.JDKDynamicProxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by Tom on 2019/3/10.
 */
public class GPProxyTest {

    public static void main(String[] args) {
        try {

            //JDK动态代理的实现原理
            Person obj = (Person) new GPMeipo().getInstance(new Customer());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
