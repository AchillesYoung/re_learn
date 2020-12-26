package DataStructure.sort;

import com.apple.laf.AquaIcon;

import java.util.Arrays;

import static DataStructure.sort.Sort.*;

public class QuickSortBase {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort(arr, 0, arr.length - 1);

    }

    public static void sort(int[] arr, int left, int right) {

        if (left < right) {
            int pivot = (int) (Math.random() * (right - left + 1));
            swap(arr, left+pivot, right);
            int[] pivotArray = partitioner(arr, left, right);
            sort(arr, left, pivotArray[0]);
            sort(arr, pivotArray[1], right);
        }
    }


    private static int[] partitioner(int[] arr, int left, int right) {

        int less = left - 1;
        int more = right;
        int cur = left;
        while (cur < more) {
            if (arr[cur] < arr[right]) {
                //还是指的less的下一个
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[right]) {
                //如果大于了，就把more的区域扩大
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        swap(arr, more, right);
        return new int[]{less, more+1 };
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
            sort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucked!");
        int[] arr = new int[]{5, 8, 2, 3, 0, 7, 4, 6};
        printArray(arr);

        sort(arr);
        System.out.println();
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);

        System.out.println();

    }

}
