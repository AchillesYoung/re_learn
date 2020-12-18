package Lead2Offer.HashMap;

import java.util.HashMap;

public class TwoSum {

    public int [] solution(int [] arr,int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i< arr.length; ++i){
            /**
             *   nums = [3,1,3,6], target = 6 ，算法应该返回数组 [0,2] ，因为 3 + 3 = 6。
             *   这里不要管覆盖，一样的话，我们后续是从头开始遍历的时候
             *   hashMap.get(target - arr[i])拿到的是最后一个覆盖的
             */

            hashMap.put(arr[i], i);
        }
        for(int i =0;i<arr.length;i++){
            if(hashMap.containsKey(target - arr[i])&& hashMap.get(target - arr[i]) !=i){
                return new int[] {i, hashMap.get(target - arr[i])};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int x = -1, y = 2;
        boolean f = ((x ^ y) < 0);
        System.out.println(x ^ y);
        System.out.println(f);
    }
}
