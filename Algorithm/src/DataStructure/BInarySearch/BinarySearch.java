package DataStructure.BInarySearch;

import org.junit.Test;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/24-5:11 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class BinarySearch {

    public boolean exsit(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int l = 0;
        int r = sortedArr.length - 1;
        int mid = 0;
        while (l < r) {

            //带符号右移动一位
            mid = l + ((r - l) >> 1);
            if (sortedArr[mid] == target) {
                return true;
            } else if (sortedArr[mid] < target) {
                l = mid + 1;
            } else if(sortedArr[mid] > target){
                r = mid - 1;
            }

        }
        return sortedArr[l] == target;
    }

    @Test
    public void test01() {

        int[] arr = new int[]{0, 1, 2, 2, 4, 4, 5, 7};

        System.out.println(exsit(arr, 10));


    }
}