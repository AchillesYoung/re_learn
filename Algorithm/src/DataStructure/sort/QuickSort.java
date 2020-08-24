package DataStructure.sort;


import java.util.Arrays;

public class QuickSort extends Sort {
//
    static void quickSort(int [] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //快排主流程
        quickSort(arr, 0, arr.length - 1);

    }
    static void quickSort(int [] arr, int left, int right){
        // left只能下于right，不然就结束
        if(left >= right){
            return;
        }
        //参考坐标，
        int pivotIndex  = partition(arr, left, right);
        quickSort(arr,left,pivotIndex-1);
        quickSort(arr, pivotIndex+1, right);

    }
    static int partition(int [] arr, int left, int right ){
        //每次选开头的为num参考
        int pivot = arr[left];

        while(left != right){
            while(arr[right] >=pivot && left<right){
                right--;
            }
            //right小于tmp,和left交换
            arr[left] = arr[right];
            while(arr[left] <= pivot && left <right){
                //cur<num, left++ cur++
                left ++;
            }
            arr[right] = arr[left];

        }
        arr[left] = pivot;
        return left;
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
