package grace.shuati;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that
 * the sum is closest to a given number, target. Return the sum of the three integers.
 */

// a + b = -c (for loop through c)
// closest -> larger vs smaller
public class ThreeSumClosest {
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 2; i++) {
            // find the sum of two integers that is closest to -nums[i]
            int closest = twoSum(numbers, i+ 1, numbers.length - 1, target - numbers[i]);

            if (sum == Integer.MAX_VALUE || Math.abs(target - sum) >= Math.abs(target - numbers[i] - closest)) {
                sum = numbers[i] + closest;
            }
        }
        return sum;
    }

    // method that return the sum of two integers that is closest to target
    private int twoSum(int[] nums, int start, int end, int target) {
        // closest larger pair
        int upper = Integer.MAX_VALUE, lower = Integer.MIN_VALUE;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return target;
            } else if (nums[start] + nums[end] > target) {
                upper = Math.min(upper, nums[start] + nums[end]);
                end--;
            } else {
                lower = Math.max(lower, nums[start] + nums[end]);
                start++;
            }
        }
        if ((long)Math.abs((long)upper - target) >= (long)Math.abs((long)target - lower)) {
            return lower;
        }
        return upper;
    }
}
