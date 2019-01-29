package grace.shuati;

import java.util.Arrays;

/**
 * Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
 * Return the difference between the sum of the two integers and the target.
 */

// find the closest pair that is smaller to the target and larger to the target
// compare these two and find the smallest difference
// how to find these two pairs? - keep an int
public class TwoSumClosestToTarget {
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        Arrays.sort(nums);
        int large = Integer.MAX_VALUE, small = Integer.MIN_VALUE;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return 0;
            } else if (nums[start] + nums[end] > target) {
                large = Math.min(large, nums[start] + nums[end]);
                end--;
            } else {
                small = Math.max(small, nums[start] + nums[end]);
                start++;
            }
        }
        if (start == 0) {
            return large - target;
        } else if (end == nums.length - 1) {
            return target - small;
        }
        return Math.min(large - target, target - small);
    }
}
