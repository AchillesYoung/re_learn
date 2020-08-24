package ProblemMet;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/7/10-11:27 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class ParamTest {

    /**
     * 对象传递给方法内部的引用，两个引用指向同一个对象，如果这时候修改就是修改了两个引用的值
     * 但是方法内部的引用这时候指向了新的person对象
     * 所以，第二次修改的是这个新的对象根之前没关系了，现在是两个引用都指向不同的对象
     * @param person
     */
    public static void instance(Person person) {
        person.name = "instance";
        System.out.println("method方法内第一次修改：" + person.name);
        person = new Person(); // 新创建一个对象
        person.name = "new+instance";
        System.out.println("method方法内第二次修改：" + person.name);
    }


    public static String test(String str) {
        str = str + "2";
        System.out.println(str);
        return str;
    }


    public static void main(String[] args) {
        Person person = new Person();
        person.name = "main" ;
        // 把main方法中的变量person所引用的内存空间地址，按引用传递给method方法中的person变量
        // 请注意：这两个person变量是完全不同的，不要被名称相同所蒙蔽
        System.out.println("调用method方法之前：" + person.name);
        instance(person);
        System.out.println("调用method方法之后：" + person.name);
    }
}

class Person {
    public int age;
    public String name;
}

