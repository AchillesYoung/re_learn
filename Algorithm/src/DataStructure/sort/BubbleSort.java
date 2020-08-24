package DataStructure.sort;

import java.util.Arrays;
/**
 * 相邻比，找到最大
 * "bubble : time+O(n^2), spaceO(1)"
 */
public class BubbleSort extends Sort {


    static void bubble_sort(int[] unsorted) {

        if (unsorted == null || unsorted.length < 2) {
            return;
        }
        /**
         * 可以优化，如果这轮一个都没有交换，说明已经排序完成，就可以结束,省了不少时间
         */
        for (int e = unsorted.length - 1; e > 0; e--) {
            boolean flag =true;
            for (int i = 0; i < e; i++) {
                if (unsorted[i] > unsorted[i + 1]) {
                    swapBit(unsorted, i, i + 1);
                    flag =false;
                }
            }
            if(flag){
                break;
            }
        }

    }


    static void bubble(int[] unsorted) {

        if (unsorted == null || unsorted.length < 2) {
            return;
        }
        /**
         * unsorted.length=6
         * if i=4, unsorted.length-i-1=6-4-1,根本不进来
         */
        for (int i = 0; i < unsorted.length - 1; i++) {

            //unsorted.length - i-1 不然j<unsorted.length - 0， j+1=unsorted.length - 0+1+1指针越界
            for (int j = 0; j < unsorted.length - i - 1; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    swapBit(unsorted, j, j + 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("bubble : time+O(n^2), spaceO(1)");
        int testTime = 500;
        int maxSize = 15;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            bubble_sort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fuck!");
//        int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arr = new int[]{6, 5, 1, 2, 4, 3};
        printArray(arr);
        bubble_sort(arr);
        printArray(arr);
    }
}

