package DataStructure.sort;

import java.util.Arrays;

/**
 * 为了保证分组粗调没有盲区，每一轮的增量需要彼此“互质”，也就是没有除1之外的公约数。
 * 于是，人们相继提出了很多种增量方式，其中最具代表性的是Hibbard增量和Sedgewick增量。
 * Hibbard的增量序列如下：
 * 1，3，7，15......
 * 通项公式 2^k-1
 * 利用此种增量方式的希尔排序，最坏时间复杂度是O（n^(3/2)）
 * Sedgewick的增量序列如下：
 * 1, 5, 19, 41, 109......
 * 通项公式 9*4^k - 9*2^k + 1 或者 4^k - 3*2^k + 1
 * 利用此种增量方式的希尔排序，最坏时间复杂度是O（n^(4/3)）
 * 关于这两种增量方式的时间复杂度，有些需要很复杂的数学证明，有些是人们的大致猜想，大家暂时不用纠结。
 */
public class ShellSort extends Sort {

    static void shell_sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int gap = 1;
        while (gap > 0) {
            //从gap开始是因为，每次都把前一个当作已经排序的数组
            for (int i = gap; i < arr.length; i++) {
//                当前的
                int tmp = arr[i];
                //前一个
                int j = i - gap;
                //只有前一个大于当前的,才进去循环，不然结束这轮插入排序
                while (j >= 0 && arr[j] > tmp) {

                    //和j要和前一个交换，前一个
                    arr[j + gap] = arr[j];
                    //和更前gap一个比较
                    j -= gap;
                }
                /**
                 *抖一个小机灵，把有序数组的前一个放在tmp里面然后，
                 * 最后不交换了我们才把tmp放在该位置，减少交换频率
                 */
                //交换结束了，把未排序的前一个放在
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
    }


    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            shell_sort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        shell_sort(arr);
        printArray(arr);
    }
}
