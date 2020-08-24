package thread;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/5/7-5:54 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class DaemonDemo {


    public static void main(String[] args) {
        MyDaemon m = new MyDaemon();
        m.setDaemon(true);
        m.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}

class MyDaemon extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("MyDaemon");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
