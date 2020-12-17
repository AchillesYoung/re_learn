package Lead2Offer.sort;

import java.util.HashMap;
import java.util.Map;

public class BucketSort {
    /**
     * 看了上面的分析，既然桶排序时间复杂度为线性，
     * 是不是就能替代例如快排、归并这种时间复杂度为O(nlogn)的排序算法呢？
     * 答案是否定的，桶排序的应用场景十分严苛，
     * 首先，数据应该分布比较均匀。讲一种较坏的情况，如果数据全部都被分到一个桶里，
     * 那么桶排序的时间复杂度是不是就退化到O(nlogn)了呢？
     * 其次，要排序的数据应该很容易分成m个桶，每个桶也应该有大小顺序。
     */

    public void bucket_sort(int[] arr, int valueRange) {
        if(arr.length < 2 || arr == null ){
            return;
        }
        Map<Integer, Integer> bucketMap = new HashMap<>();//这个思路对吗
        //但是应该是数组，索引代码值，存的数据是该值的个数
        int[] bucket = new int[valueRange + 1];
        for (int i = 0; i < arr.length; ++i) {
            bucket[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; ++i) {
            while (bucket[i]-- > 0) {
                arr[index++] = i;
            }
        }

    }
}
