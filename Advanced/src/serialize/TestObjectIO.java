package serialize;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/12/11-3:58 PM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public class TestObjectIO {
    // 测试数组的序列化
    @Test
    public void test3() throws IOException {

            Person p1 = new Person("花无缺", 18, 180);
            Person p2 = new Person("小鱼儿", 18, 160);
            Person p3 = new Person("燕南天", 40, 180);

            Person[] pers = { p1, p2, p3 };
            List<Person> list = new ArrayList<>();

            list.add(p1);
            list.add(p2);
            list.add(p3);

            // 1.创建序列化流对象
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person2.dat"));

            // 2.序列化对象
            oos.writeObject(list);
            // 3.关闭
            oos.close();
    }



    @Test
    public void test4() throws Exception {
            // 1.创建反序列化流对象
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person2.dat"));

            // 2.反序列化对象
//		Person[] pers = (Person[]) ois.readObject();

            List<Person> list = (List<Person>) ois.readObject();
            for (Person person : list) {
                System.out.println(person);
            }

            // 3.关闭
            ois.close();
    }

    @Test
    public void test1() throws IOException {

        Person p1 = new Person("花无缺", 18, 180);
        Person p2 = new Person("小鱼儿", 18, 160);
        Person p3 = new Person("燕南天", 40, 180);

        // 1.创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"));

        // 2.序列化对象
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);

        // 3.关闭
        oos.close();

    }

    @Test
    public void test2() throws ClassNotFoundException, IOException {
        // 1.创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"));

        // 2.反序列化对象
        System.out.println(ois.readObject());
        System.out.println(ois.readObject());
        System.out.println(ois.readObject());

        // 3.关闭
        ois.close();
    }

}
