package thread;

/**
 * 内存可见
 */
public class VolatileDemo {

    public static void main(String[] args) {

        ThreadFlag thread = new ThreadFlag();
        new Thread(thread).start();
        while (true) {
            if(thread.isFlag()){
                System.out.println("-----");
                break;
            }
        }
    }

}


class ThreadFlag implements Runnable {


    public boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag="+isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}