package DataStructure.sort;


import java.util.Arrays;

public class InsertSort extends Sort {

    /**
     * 插入排序，从到尾，依次扫描未排序序列，将扫描到的每个元素插入到你之前有序序列的适当位置。
     * （如果相等，将元素插入到该元素后面)
     * @param arr
     */
    static void insertSort(int [] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i =1; i< arr.length; i++){
            //当作第一个是已经排序的序列，所以i从1开始， 开始扫描未排序的序列
            for(int j=i-1;j>=0 && arr[j+1]<arr[j];j--){
               swapBit(arr,j,j+1);
            }
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
            insertSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }


}
