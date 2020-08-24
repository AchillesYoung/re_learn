package thread;

/**
 *  yield();
 *  threadDemo1.join();
 *  threadDemo1.alive();
 *  setName(),getName()
 *  currentThread()
 *  setPriority()
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() +"_" +this.getPriority()+ "_" + i);
            }
            //当满足这个条件，让出cpu控制权给别的线程
            if (i % 20 ==0) {
                yield();
            }
        }
    }

}

class ThreadTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo();
        threadDemo1.setName("one");
        threadDemo1.setPriority(Thread.MAX_PRIORITY);
        //main线程
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        threadDemo1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println("thread_main:" + i);
            }
            //join 用来，别的线程调用来优先执行完成，因为有时候，主线成，需要别的线程提供的数据，所以等他们执行完再
            //在线程a中调用线程b.join(),此时a线程进入堵塞状态，而且等待b执行完才
            if(i==20){
                System.out.println(threadDemo1.isAlive());//true
                try {
                    threadDemo1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadDemo1.isAlive());//false
            }
        }
//        ThreadDemo threadDemo2 = new ThreadDemo();
//        threadDemo2.start();

    }

}
