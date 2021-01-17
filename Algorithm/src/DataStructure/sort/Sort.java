package DataStructure.sort;

import java.util.Arrays;

/**
 * 排序算法可以分为内部排序和外部排序。
 * <p>
 * 内部排序是数据记录在内存中进行排序。
 * <p>
 * 而外部排序是因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。
 */
public class Sort {

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //长度随机
        int length = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    public static void swapBit(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(int i, int j) {
        i ^= j;
        j ^= i;
        i ^= j;
    }

    public static void main(String[] args) {
//        int [] arr = new int[]{6,5,1,2,4,3,};
//        printArray(arr);
//        int i=1;
//        int j=3;
//        swapBit(arr,--j,i++);
//        printArray(arr);

        int a = 3;
        int b = 2;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);

    }


    //copy arr to new address
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        //不判断空，后面会报空指针
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//
//
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        int testTime = 500000;
//
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//
//            BubbleSort.bubble_sort(arr1);
//            Arrays.sort(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//
//        System.out.println(succeed ? "Nice!" : "Fuck!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        BubbleSort.bubble_sort(arr);
//        printArray(arr);

}


//
//    }
