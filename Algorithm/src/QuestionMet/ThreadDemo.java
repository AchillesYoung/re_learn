package QuestionMet;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ThreadDemo {

    static class SleepThread extends Thread {
        boolean flag = true;//通过把flag置为flase结束线程

        @Override
        public void run() //每隔一秒打印一次时间
        {
            while (flag) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

                try {
                    sleep(1000); //每隔一秒打印一次时间
                } catch (InterruptedException e) {
                    System.out.println("捕捉到了");
                    flag = false;
                    e.printStackTrace();
                }
            }
            System.out.println("InterruptedException");
        }
    }

    public static void main(String[] args) {
        SleepThread x = new SleepThread();
        x.start();

        try {
            Thread.sleep(5000);//主线程sleep 10秒
        } catch (InterruptedException e) {
        }

        x.interrupt();//10秒后打断子线程，子线程会抛出InterruptedException
    }

}
