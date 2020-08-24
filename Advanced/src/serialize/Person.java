package serialize;

import java.io.*;

/**
 * 编写Person类，包含姓名、年龄、体重等属性，提供对应的访问方法；
 * 编写测试类1，在main方法中创建三个不同的Person对象，将这三个对象序列化到文件中；
 * 编写测试类2，在main方法中从文件中反序列化三个Person对象，打印输出。验证序列化的正确；
 * 在测试类1中，将三个Person对象放到数组中，序列化该数组到一个独立的文件中。再将三个Person对象放到List集合中，序列化该集合到另一个独立的文件中；
 * 在测试类2中，将三个Person对象从数组文件中反序列化，并打印；
 * 将三个Person对象从List集合文件中反序列，并打印。验证数组对象和集合对象的序列化。
 */

class Computer implements Serializable {
    String name;

    public Computer(String name) {
        super();
        this.name = name;
    }
}

class Student extends Person{

    public Student(String name, int age, double weight) {
        super(name, age, weight);
    }

}
public class Person implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -95883481082677658L;
    /**
     *
     */
//	private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double weight;

    Computer com;

    private transient String nation;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Person(String name, int age, double weight, String nation,Computer com) {
        super();
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.nation = nation;
        this.com=com;
    }
    public Person(String name, int age, double weight) {
        super();
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Person(String name) {
        this.name = name;
    }

    //	@Override
//	public String toString() {
//		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
//	}
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", weight=" + weight + ", nation=" + nation + "]";
    }

}
