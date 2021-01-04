package DataStructure.Hashmap;

import java.util.*;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/7/27-11:12 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class twoSum {


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
             int complement = target - nums[i];
             if(map.containsKey(complement)){
                 return new int[] { i, map.get(complement) };

             }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
