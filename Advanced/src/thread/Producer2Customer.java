package thread;

import com.sun.deploy.util.Waiter;

/**
 * 线程通信的例子：使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *    否则，会出现IllegalMonitorStateException异常
 * 3.wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中。
 *
 * 面试题：sleep() 和 wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep() , Object类中声明wait()
 *          2）调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
 *          3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
 *
 * @author shkstart
 * @create 2019-02-15 下午 4:21
 */
public class Producer2Customer {

    private static int MAX_VALUE = 10;
    private int num;


    public synchronized void put() {

        //要用while
        try {
            while (num >= MAX_VALUE) {
                System.out.println("停产");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(300);
            //加入睡眠时间是放大问题现象，去掉同步和wait等，可观察问题
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产中");
        num++;
        System.out.println("厨师"+Thread.currentThread().getName()+"制作了一份快餐，现在工作台上有：" + num + "份快餐");
        this.notify();
    }

    public synchronized void take() {

        while (num <= 0) {
            System.out.println("吃停");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费中");
        num--;
        System.out.println("服务员"+Thread.currentThread().getName()+"取走了一份快餐，现在工作台上有：" + num + "份快餐");
        this.notify();
    }


    public static void main(String[] args) {
        Producer2Customer bench = new Producer2Customer();
        Producer p = new Producer(bench);
        Customer c = new Customer(bench);

        Customer c1 = new Customer(bench);
        Producer p1 = new Producer(bench);


        c.start();
        c1.start();
        p1.start();
        p.start();

    }

}


class Producer extends Thread {
    private Producer2Customer workbench;

    public Producer(Producer2Customer workbench) {
        super();
        this.workbench = workbench;
    }

    /**
     * 消费直到0
     */
    @Override
    public void run() {
        while (true){

            workbench.put();
        }
    }
}


class Customer extends Thread {
    private Producer2Customer workbench;

    public Customer(Producer2Customer workbench) {
        super();
        this.workbench = workbench;
    }

    /**
     * 生产直到10
     */
    @Override
    public void run() {
        while (true){

            workbench.take();
        }
    }
}
