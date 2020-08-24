package Lead2Offer.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 技巧一：数组排序，如果存在，必定在中间那个
 * 技巧二: 摩尔投票算法是基于这个事实：
 * // 每次从序列里选择两个不相同的数字删除掉（或称为“相互抵消”），
 * // 最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个
 * 时间和空间复杂度分别为O(N)和O(1)
 * 三：基本求法是建立hash表：//时间O(n)，空间O(n/2)，基本上一半就可以出结果了
 */
public class FindHalfAppear {


    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public int hashMap(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap();
        int res = 0, len = nums.length;
        for(int i = 0; i < len; i++){
            if(map.containsKey(nums[i])) {
                //这里不能直接map.get(nums[i])++;
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }

            //不必等到哈希表完全建立再进行此判断
            if(i>=len/2&&map.get(nums[i]) > len/2){
                res = nums[i];
            }
        }
        return res;
    }

    public int moore(int[] nums) {
        int target = nums[0];//初始化为数组的第一个元素，接下来用于记录上一次访问的值
        int  votes=0;

        for (int i = 1; i < nums.length; i++) {
            if(votes==0){
                target = nums[i];
            }
            votes += (target == nums[i])?1:-1;
        }
        return target;

    }


}
