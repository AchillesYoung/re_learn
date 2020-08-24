package DataStructure.sort;

import java.util.Arrays;

/**
 * 通排序：计数排序/基数排序（不是基于比较器实现的方法）
 * BucketSort复杂度O(n)
 * 基数排序用桶的方式更精致，按照个十百位排序
 */
public class BucketSort extends Sort {
    /**x
     遇到了问题，就是插入桶的时候一直越界，主要原因是index来回转换的时候，出现问题，从arr里拿出来的数
     可以直接当索引插入bucket，因为index是从0开始的，不需要再+1
     */
    //传入的是10
    static void bucket_sort(int [] arr, int valueRange){

        if(arr.length < 2 || arr == null ){
            return;
        }
        //桶是11长度，0-10
        int [] bucket = new int[valueRange+1];
//        printArray(bucket);
        int insert=0;
        int temp = 0;
        /**if arr[0] = 6, -> bucket[7], bucket[7] +1=1
         arr[1] = 6, anb bucket[7]=1, bucket[7] +1=2*/
        for(int i=0; i < arr.length; i++){
            //遍历数组，拿到每一个要插入的桶坐标位置
            insert =arr[i];
            temp =bucket[insert];
            bucket[insert] = temp+1;
        }
        //重新排序的数组位置，要一个个从小到大替换
        int point = 0;
        //开始遍历桶，现在bucket[7]= 2
        for(int j=0; j<bucket.length; j++){
            //从桶里面一个个遍历，如果大于0说明存在，那么就把arr[point]个该桶坐标插入到之前数组里面
            //bucket[0]=1, 进去循环，arr[0] = 0; point=1 bucket[0]-1=0，
            //跳出循环
            while(bucket[j]>0){
                //为了省空间。point是刷新老数组
                arr[point]=j;
                bucket[j]--;
                point++;
            }
            //直到桶最后位置，插入结束
        }

    }
    //优化版本
    static void bucket_sort(int [] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        int max =Integer.MIN_VALUE;
        for(int index = 0; index< arr.length; index++){
            max = Math.max(max, arr[index]);
            //max = arr[index] > max ? arr[index] : max;
        }
        int [] bucket = new int[max+1];
        /**if arr[0] = 6, anb bucket[7], bucket[7] +1=1
         arr[1] = 6, anb bucket[7]=1, bucket[7] +1=2*/
        for(int i=0; i < arr.length; i++){
            //遍历数组，拿到每一个要插入的桶坐标位置
            bucket[arr[i]]++;
        }
        //重新排序的数组位置，要一个个从小到大替换
        int insert = 0;
        //开始遍历桶，现在bucket[7]= 2
        for(int j=0; j<bucket.length; j++){
            //从桶里面一个个遍历，如果大于0说明存在，那么就把arr[point]个该桶坐标插入到之前数组里面
            //bucket[0]=1, 进去循环，arr[0] = 0; point=1 bucket[0]-1=0，
            //跳出循环
            while(bucket[j]-- >0){
                arr[insert++]=j;
            }
            //直到桶最后位置，插入结束
        }
    }

    public static void main(String[] args) {
        int testTime = 500;
        int maxSize = 100;
        int maxValue = 150;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            bucket_sort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fuck!");
//        int[] arr = generateRandomArray(maxSize, maxValue);
        int [] arr = new int[]{6,6,5,1,2,4,3,8,10,0};
        printArray(arr);
        bucket_sort(arr,10);
        printArray(arr);
    }


}
