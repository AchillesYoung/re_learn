package Lead2Offer.sort;


import java.lang.reflect.Array;
import java.util.Arrays;

import static Lead2Offer.sort.odd_even.swap;

/**
 * [0,1,1,2,1,0,1]
 */
public class TreeNumberSort {

    public static void solution(int[] arr) {

        int less = -1;
        int more = arr.length;
        int cur = 0;
        //找到第一个 0
        //找到第一个 1
        while (cur < more) {
            if (arr[cur] == 2) {
                swap(arr, cur, --more);
            } else if (arr[cur] == 0) {
                //把0和1的位置换一下
                swap(arr, cur++, ++less);
//                less++;
            } else {
                cur++;
            }
        }
    }


    public static void solution2(int[] array) {

        int less = -1;
        int more = array.length;
        int cur = less+1;
        while (cur < more) {
            if (array[cur] == 1)
                cur++;
            else if (array[cur] == 0) {
                swap(array, ++less, cur++);
            } else {
                swap(array, --more, cur);
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 0, 1, 2, 1, 0, 2, 2, 1};
        System.out.println(Arrays.toString(arr));
        solution2(arr);
        System.out.println(Arrays.toString(arr));
    }


    //        while (arr[less] == 0 && less < arr.length) {
//            less++;
//        }
//        while (arr[more] == 2 && more >= 0) {
//            more--;
//        }
//        cur = less;
}
