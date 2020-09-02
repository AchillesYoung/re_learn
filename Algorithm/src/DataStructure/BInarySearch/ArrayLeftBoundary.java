package DataStructure.BInarySearch;

import java.util.ArrayList;

/**
 * TODO
 * <p>
 * 寻找数组里面目标数组的左边界。这次不是找他是否存在，是要找数组里（包括重复）该数字的最左边
 */
public class ArrayLeftBoundary {

    public int leftBoundary(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        //因为right = arr.length，左边开，右边关
        int left = 0;
        int right = arr.length;

        //不是left = mid只是想着
        while (left < right){
            /**
             * 要找左边所有最小的，所以right=mid，包左不包右边
             */
            int mid = left + (right - left)>>1;
            if(arr[mid] == target){
                right = mid;
            }else if(arr[mid] > target){

                //不是right = mid -1;
                // 一直要包左不包右边，[left,right)
                right = mid;
            }else if(arr[mid] < target){
                //比目标小的肯定没用了，直接+1
                left = mid +1;
            }
        }
    //left = right
        return right;
    }


    public int leftNest(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length -1 ;
        int index = -1;

        while (left <= right){
            int mid = left + ((right - left)>>1);
            if(arr[mid] >= target){
                index  =mid;
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        //left = right
        return index;
    }
}
