package Proxy.JDKDynamicProxy;


public class Customer implements Person {

    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高 180cm");
        System.out.println("胸大，6 块腹肌");
    }

    @Override
    public void marry() {
        System.out.println("marry");
    }

}


