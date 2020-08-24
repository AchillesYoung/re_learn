package Lead2Offer.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 只是时间优先就用字典(简单）
 * 还有空间要求，就用指针+原地排序数组（有空间要求，就是直接排序）
 * 如果要求空间O(1)并且不能修改原数组，还得写成二分法！！！
 */
public class RepeatNumArray {
    /**
     * 集合的特性
     * set/Array
     * 不重复元素，有一个add方法，返回的是boolean，意思是成功不成功，如果有了就返回false
     * 用hashset别用链表set
     * 时间复杂O(n),空间复杂O(n)
     */

    public static int findRepeatNumberBySet(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {

            if (!hashSet.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findRepeatNumberByArr(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[nums[i]] += 1;
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 5, 6, 4};
        System.out.println(findRepeatNumberBySet(arr));
    }
}
