package DataStructure.sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/5/28-12:55 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class QuickSortV2 extends Sort {


    static void quickSort(int [] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length - 1);

    }
    static void quickSort(int [] arr, int left, int right){
        // left只能下于right，不然就结束
        if(left < right){
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            //参考坐标，
            int pivotArry []  = partition(arr, left, right);
            quickSort(arr,left,pivotArry[0]-1);
            quickSort(arr, pivotArry[1]+1, right);
        }


    }
    static int [] partition (int [] arr, int left, int right){
        //每次选开头的为num参考

        int less = left - 1;
//        left就是cur right就是 pivot
        /**
         * more和less就是两个区域划分线
         */
        int more = right;
        int cur = left;
        //arr[right]=num
        while (cur < more) {
            if (arr[cur] < arr[right]) {
                //if cur <num,cur的位置和less++换，less区域也变大，然后cur++
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[right]) {
                //if cur>num,more--的位置和cur换，然后继续循环
                swap(arr, --more, cur);
            } else {
//                不然就是相等，就直接++
                cur++;
            }
        }
//        结束cur=more
        swap(arr, more, right);
//        前面less-1，现在more+1
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucked!");
        int [] arr = new int[]{6,5,1,2,4,3};
        printArray(arr);

        quickSort(arr);
        System.out.println();
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);

        System.out.println();

    }
}
