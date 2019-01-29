package grace.shuati;

import java.util.Arrays;

/**
 * Given an array of integers, find how many unique pairs in the array
 * such that their sum is equal to a specific target number. Please return the number of pairs.
 */

public class TwoSumUniquePairs {
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] == target) {
                if (start == 0 || (start != 0 && nums[start] != nums[start - 1])) {
                    count++;
                    start++;
                    end--;
                } else {
                    start++;
                    end--;
                }
            }
        }

        return count;
    }
}
