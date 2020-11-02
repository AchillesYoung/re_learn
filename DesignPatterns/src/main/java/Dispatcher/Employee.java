package Dispatcher;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/10/30-3:07 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class Employee implements IEmployee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void work(String command) {
        System.out.println("I am" + name + "do" + command + ",well done");
    }
}
