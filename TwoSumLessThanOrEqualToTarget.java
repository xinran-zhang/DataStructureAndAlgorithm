package grace.shuati;

import java.util.Arrays;

/**
 * Given an array of integers, find how many pairs in the array such that their sum
 * is less than or equal to a specific target number. Please return the number of pairs.
 */

public class TwoSumLessThanOrEqualToTarget {
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] <= target) {
                count = count + (end - start);
                start++;
            }
        }

        return count;
    }
}
