package Lead2Offer.sort;

import DataStructure.sort.Sort;

public class QuickSort {

    static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //快排主流程
        quickSort(arr, 0, arr.length - 1);

    }

    static void quickSort(int[] arr, int left, int right) {
        // left只能<right，不然就结束
        if (left >= right) {
            return;
        }
        //参考坐标，
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);

    }

    static int partition(int[] arr, int left, int right) {
        //,这里是选开头num当参考的方法
        int pivot = arr[left];

        //挖坑法
        while (left != right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            //right小于tmp,和left交换
            arr[left] = arr[right];
            while (arr[left] <= pivot && left < right) {
                //cur<num, left++ cur++
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = pivot;
        return left;
    }
}
