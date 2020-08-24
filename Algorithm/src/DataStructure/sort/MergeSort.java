package DataStructure.sort;


import java.util.Arrays;

/**
 * 归并排序题目，小和问题
 */
public class MergeSort extends Sort{


    static void merge_sort_recursive(int [] arr){
        if(arr ==null || arr.length <2){
            return;
        }
        merge_sort(arr,0,arr.length-1);
    }
    static void merge_sort(int [] arr, int left, int right){
        //basic line r=l
        //不分了，分好了
        if(left == right){
            return;
        }
        //数组「3，2，1，4，5，2」
        //mid (0+5)/2=2 arr[mid] =1 「3，2，1」
        int mid = left + ((right - left) >> 2);

        //进入递归左边，---->  重新计算mid=0+2/2=1,「3，2」right = 2---->继续递归left=right=0，mid=0
        merge_sort(arr, left, mid);//T(n/2)
        //自此执行这一步 left=right=1，mid=1
        merge_sort(arr, mid+1, right);//T(n/2)
        //O(N)
        mergeProcess(arr, left, right,mid);//执行marge --->【3，2】 最底层递归结束，上跳
        //第二次递归的时候【3，2】 和【1】进行marage，完事，arr里面left到right的位置已经有序，继续合并递归
        //T(n)=T(n/2)+T(n/2)+O(N)
    }


    static void mergeProcess(int [] arr, int left, int right,int mid){

        //这里可以搞一个大一点的公共数组，全局的不用销毁
        int[] help = new int[right - left + 1];
        int i = 0;
        int point1 = left;
        int point2 = mid+1;
        while(point1 <= mid && point2<=right){
            help[i++] = arr[point1] < arr[point2] ? arr[point1++] : arr[point2++];
        }
        while(point1 <= mid){
            help[i++] = arr[point1++];

        }
        while(point2 <= right){
            help[i++] = arr[point2++];

        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            merge_sort_recursive(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucked!");



    }
}
