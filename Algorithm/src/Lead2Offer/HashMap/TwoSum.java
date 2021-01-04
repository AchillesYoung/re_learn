package Lead2Offer.HashMap;

import java.util.HashMap;

public class TwoSum {

    public int[] solution(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(target - arr[i]) && hashMap.get(target - arr[i]) != i) {
                return new int[]{i, hashMap.get(target - arr[i])};
            }
            hashMap.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int x = -1, y = 2;
        boolean f = ((x ^ y) < 0);
        System.out.println(x ^ y);
        System.out.println(f);
    }
}
