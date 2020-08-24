package Lead2Offer.Recursive;

import org.junit.Test;

import java.util.Random;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/6/10-11:47 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class RecursiveValue {


    private static int big = 10;

    public static Integer rand() {
        Random random = new Random();
        int i = random.nextInt(100);
        return i;
    }

    public static Integer recursive() {
        Integer s = null;
        Integer rand = rand();
        Integer a = 0;
        if (rand % 3 == 0) {
            s = rand;
            return s;
        } else if (rand % 3 != 0) {
            if (big > 0) {//不包含0
                big--;

                a = recursive();
                System.out.println(a);
            }
        } else {
            a = 100000;
            return a;
        }
        System.out.println(s);
        return a;
    }

//    @Test
//    public void invoke() {
//        Integer digui = recursive();
//        System.out.println(digui);
//    }

//3
    public static int fib(int x) {
        if (x == 1) {

            return 1;
        }
        if (x == 0) {

            return 0;
        }

        //return f1+f0+1
        return fib(x -1 ) + fib(x-2);

    }

    public static void main(String[] args) {
        System.out.println(recursive());
    }


}
