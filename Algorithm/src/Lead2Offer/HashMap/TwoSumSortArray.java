package Lead2Offer.HashMap;

public class TwoSumSortArray {

    int[] twoSum(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left--;
            }
        }
        return new int[]{-1, -1};
    }
}
