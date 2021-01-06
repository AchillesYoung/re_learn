package QuestionMet;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ThreadDemo {

    static class SleepThread extends Thread {
        boolean flag = true;//ͨ����flag��Ϊflase�����߳�

        @Override
        public void run() //ÿ��һ���ӡһ��ʱ��
        {
            while (flag) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
                System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��

                try {
                    sleep(1000); //ÿ��һ���ӡһ��ʱ��
                } catch (InterruptedException e) {
                    System.out.println("��׽����");
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
            Thread.sleep(5000);//���߳�sleep 10��
        } catch (InterruptedException e) {
        }

        x.interrupt();//10��������̣߳����̻߳��׳�InterruptedException
    }

}
