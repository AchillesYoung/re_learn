package thread;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/5/7-11:06 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class TicketService {

    private ArrayList<String> list;

    public TicketService() {
        list = new ArrayList<String>();
        list.add("01车01A");
        list.add("01车01B");
        list.add("01车01C");
        list.add("01车01D");
        list.add("01车01E");
        list.add("01车02A");
        list.add("01车02B");
        list.add("01车02C");
        list.add("01车02D");
        list.add("01车02E");
    }

    public synchronized boolean hasTicket() {
        return list.size() > 0;
    }

    public synchronized String buy() {
        try {
            return list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("票卖超了");
        }
    }
    public static void main(String[] args) {
        TicketService ts = new TicketService();
        Saler s1 = new Saler(ts);
        Saler s2 = new Saler(ts);

        s1.start();
        s2.start();
    }


}


class Saler extends Thread{
    private TicketService ts;

    public Saler(TicketService ts) {
        super();
        this.ts = ts;
    }
    @Override
    public void run(){
        while(ts.hasTicket()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                String buy = ts.buy();
                System.out.println("购买票：" + buy);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("没有票了");
    }
}


