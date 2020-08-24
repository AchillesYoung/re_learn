package serialize;

import org.junit.Test;

import java.io.*;


public class ObjectIODemo {

    //serialization
    @Test
    public void test1() throws IOException {
        File file = new File("src/serialize/object.dat");

        System.out.println(file.getAbsolutePath());
        //1.Object stream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        //2. write
        oos.writeInt(100);//
        oos.writeChar('男');//
        oos.writeBoolean(true);
        oos.writeUTF("张三丰");
        oos.writeInt(200);
        oos.writeObject(new Person("john"));
        //3.close
        oos.close();
    }
    //de-serialization
    @Test
    public void test2() throws  IOException, ClassNotFoundException {
        File file = new File("src/serialize/object.dat");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        System.out.println(ois.readInt());
        System.out.println(ois.readChar());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readUTF());
        System.out.println(ois.readInt());
        System.out.println(ois.readObject());
        ois.close();
    }

}

//class Person implements Serializable {
//    String name;
//
//    public Person(String name) {
//        super();
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Person [name=" + name + "]";
//    }
//}
