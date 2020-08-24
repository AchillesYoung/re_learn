package thread;

/**
 *  h还是有局限性，因为在同步代码块只能有一个线程操作
 */
public class LockDemo {

    public static void main(String[] args) {

        int a=0;
        int i=10;
        System.out.println(a=i++);//10
        System.out.println(i);//10
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        thread1.start();
        thread2.start();


    }
}



class Ticket implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
           synchronized (obj){
//           synchronized (this){
//           synchronized (Ticket.class){
               /**
                * Class clazz = Ticket.class只会加载一次，所以是唯一的
                */
               if(ticket>0){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + "_" + ticket);

               }else {
                   break;
               }
               ticket--;
           }

        }
    }
}