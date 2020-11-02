package SerializedStream;

import java.util.Arrays;

/**
 * TODO
 */
public class Person extends Object implements Comparable<Object> {

    public int age;
    public int tall;
    public String name;
    public Person() {

    }

    public Person(int age, int tall,String name) {

        this.age = age;
        this.tall = tall;
    }
    @Override
    public int compareTo(Object p) {

        if(p instanceof Person)
        {
            Person p2 = (Person) p;
            if(this.age == p2.age){
                return this.tall - p2.tall;
            }else {
                return this.age -p2.age;
            }
        }
        throw new RuntimeException("wrong class type");

    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                ", tall=" + tall +
//                '}';
//    }

//    public static void main(String[] args) {
//        Person p1 =new Person(20,160);
//        int result = p1.compareTo(new Person(18,170));
//        System.out.println(result);
//        Person[] arrPerson = new Person[]{new Person(18,170),new Person(20,170),new Person(18,160)};
//
//        Arrays.sort(arrPerson);
//        System.out.println(Arrays.toString(arrPerson));
//        int result2 = p1.compareTo(new PrivateTest());
//
//    }

}
