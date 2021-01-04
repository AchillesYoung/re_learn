package Lead2Offer.sort;

import DataStructure.sort.Sort;

import java.util.Arrays;

import static DataStructure.sort.Sort.*;

public class QuickSort {

    static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] pivot = partition(arr, left, right);
            quickSort(arr, left, pivot[0] - 1);
            quickSort(arr, pivot[1] + 1, right);
        }

    }


    private static int[] partition(int[] arr, int left, int right) {
        int cur = left;
        int less = left - 1;
        int more = right;
        //left 和right是不动的边界，less和more是动的
        while (cur < more) {
            if (arr[cur] < arr[right]) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > arr[right]) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }

        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
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
