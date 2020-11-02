package Dispatcher;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/10/30-3:05 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class Boss {


    public void command(String command, Leader leader) {

        leader.work(command);
    }

    public static void main(String[] args) {

    //客户请求(Boss)、委派者(Leader)、被委派者(Target/Employee)
    //委派者要持有被委派者的引用（leader要知道自己的手下情况）
    //代理模式注重的是过程，委派模式注重的是结果  //委派的核心:就是分发、调度、派遣//委派模式:就是静态代理和策略模式一种特殊的组合
        new Boss().command("登录", new Leader());
    }


}
