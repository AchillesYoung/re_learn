package SerializedStream;


import java.util.ArrayList;
import java.util.List;

/**
 * private static
 *
 * 静态方法中不能使用类的凡型，因为凡型是在运行时期
 * 泛型参数是在调方法的时候才确定的，跟实例化没关系，但是类的泛型是在实例化的时候确定的，当你调方法的时候并不知道
 * 泛型方法,需要<E>去申明这是一个泛型方法
 */
public class PrivateTest {

    private int i;

    public PrivateTest() {

    }

    public PrivateTest(int value) {
        this.i = value;
    }

    public <E> List<E> genericMethod(E [] arr){
        List<E> list = new ArrayList<>();
        for(E e :arr){
            list.add(e);
        }

        return list;

    }

    public void method() {

        PrivateTest t = new PrivateTest(10);


        System.out.println("t" + t.i);


        System.out.println("this" + this.i);

    }




    private void setA(int val) {
        this.i = 10;
    }

    private int getA() {
        return i;
    }

    @org.junit.Test
    public void genericTest2(){
        List<? super Person> list = new ArrayList<>();
        list.add(new Student());
////        list.add(new Object());
//        List<? extends Person> list2 = new ArrayList<>();
//        list2.add(new Person());

    }

}
