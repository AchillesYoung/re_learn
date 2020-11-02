package Dispatcher.SpringMVC;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/10/30-3:24 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class Controller {

    public void getMemberById(String mid) {
        System.out.println("调用MemberService");
    }

    public void getOrderById(String mid) {
        System.out.println("调用OrderService");
    }

    public void logout() {
        System.out.println("logout");
    }
}
