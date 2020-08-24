package Lead2Offer.stack_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 */
public class DequePrintTree {

    public static void main(String[] args) {
//        int size =10;
//        int a =--size;
//        System.out.println(a);

        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        String [] a1 = new String[1];
        String [] result = list.toArray(a1);
        System.out.println(result.length);
        for(String a : result){
            System.out.println(a);
        }

    }
}
