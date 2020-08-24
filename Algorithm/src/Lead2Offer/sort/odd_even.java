package Lead2Offer.sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/6/11-3:46 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class odd_even {

    /**
     * 用快排思想
     */
    public static void solution(int[] arr) {
        int odd = -1;
        int even = arr.length;
        int cur =0;
        while (even>cur){
            if (arr[cur] % 2 == 0) {
                swap(arr,cur, --even);
            }else {
                cur++;
                odd++;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int []{3,5,6,8,2,0,4,5,2,9,1};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

}
