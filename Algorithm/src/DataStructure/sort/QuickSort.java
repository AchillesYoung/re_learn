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
                /**
                 * 循环从右边开始扫描，arr[right] >=pivot，就right--
                 * 直到右边比pivot小了，停止，定位到该目标元素，等待交换，左边目标元素
                 */
                right--;
            }
            //right小于pivot,和left交换
            arr[left] = arr[right];
            while(arr[left] <= pivot && left <right){
                /**
                 * 从左边开始扫描，arr[left] <= pivot，就left++
                 * 直到左边比pivot小了，停止，定位到该目标元素，等待交换，右边的目标元素
                 */
                left ++;
            }
            //交换第一次目标元素了
            arr[right] = arr[left];
            arr[left] = pivot;

        }

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
        int [] arr = new int[]{5,8,2,3,0,7,4,6};
        printArray(arr);

        quickSort(arr);
        System.out.println();
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);

        System.out.println();

    }

}
