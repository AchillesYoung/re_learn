package thread;

/**
 * 还有安全问题
 */
public class RunnableTicket implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "_" + ticket);
            ticket--;
        }
    }
}

class RunnableTest {
    public static void main(String[] args) {

        RunnableTicket ticket= new RunnableTicket();
        Thread thread2 = new Thread(ticket);
        Thread thread = new Thread(ticket);
        thread.start();
        thread2.start();
    }

}
