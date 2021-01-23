package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    //我目前的理解，是这里不用你定义一些Function接口，jdk已经提供了一些
    /**
     * Supplier<T> ，没有参数返回一个结果
     * Predicate 输入一个参数，返回一个布尔值
     */
    public List<Integer> filterInt(List<Integer> list, Predicate<Integer> pre) {
        List<Integer> res = new ArrayList<>();
        for (Integer re : res) {
            if(pre.test(re)) res.add(re);
        }
        return res;
    }
    @Test
    public void test01(){
        List<Integer> l = new ArrayList<>();
        l.add(102);
        l.add(172);
        l.add(13);
        l.add(82);
        l.add(109);
        //Predicate 输入一个参数，返回一个布尔值，这里是一个test方法
        List<Integer> list = filterInt(l,   x -> (x > 100));
        //this is add method
        List<Integer> list2 = supplier(10, () -> new Random().nextInt(10));
    }
    //返回一个结果
    public List<Integer> supplier(int sum, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < sum; i++) {
            //这里是个get方法
            list.add(sup.get());
        }
        return list;
    }

}
