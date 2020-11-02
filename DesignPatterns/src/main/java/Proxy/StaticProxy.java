package Proxy;

/**
 * 租房中介、售票黄牛、婚介、经纪人、快递、 事务代理、非侵入式日志监听等，这些都是代理模式的实际体现。
 * 代理模式(StaticProxy Pattern)的定义也非常简单，是指为其他对象提供一种代理，以控制对这个对象的访问。
 * 代理对象在客服端和目标对象之间起到中介作用，代理模式属于结构型设计模式。
 * 代理模式有两个目的，1.保护目标对象 2.增加目标对象
 * 两种模式：静态代理和动态代理
 */
public class StaticProxy {

    public static void main(String[] args) {
        Zhihu zhihu = new Zhihu(new Son());
        zhihu.findLove();//这里通过zhihu包装增加了son，静态代理类
    }
}

interface Person {
    public void findLove();
}

//被代理类
class Son implements Person {

    @Override
    public void findLove() {
        System.out.println("2021年找到");
    }
}

//代理类
class Zhihu implements Person {

    //组合被代理类
    Person person;

    public Zhihu(Person son) {
        this.person = son;
    }

    @Override
    public void findLove() {
        System.out.println("知乎上有人联系你");
        this.person.findLove();
        System.out.println("你觉得她不错，了解以后在一起");
    }
}