package DataStructure.sort;


import java.util.Arrays;

public class SelectionSort extends Sort {

    /**
     * 选排序，每轮找最小放在首位，固定和首位交换,最简单
     * @param arr
     */
    public static void selection_sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    swapBit(arr, i, j);
                }
            }
        }

    }


    public static void selection(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

                for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swapBit(arr, i, minIndex);
        }

    }



    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selection_sort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selection_sort(arr);
        printArray(arr);
    }

}
