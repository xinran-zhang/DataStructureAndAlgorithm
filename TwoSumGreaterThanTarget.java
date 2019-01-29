package grace.shuati;

import java.util.Arrays;

/**
 * Given an array of integers, find how many pairs in the array such that
 * their sum is bigger than a specific target number. Please return the number of pairs.
 */

public class TwoSumGreaterThanTarget {
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;

        while (start + 1 < end) {
            if (nums[start] + nums[end] > target) {
                count += (end - start);
                end--;
            } else if (nums[start] + nums[end] <= target) {
                start++;
            }
        }

        if (nums[start] + nums[end] > target) {
            count++;
        }
        return count;
    }
}
