package grace.shuati;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers that their difference equals to a target value.
 * where index1 must be less than index2. Please note that your returned answers
 * (both index1 and index2) are NOT zero-based.
 */

public class TwoSumDifferenceEqualsToTarget {
    public int[] twoSum7(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target + nums[i])) {
                int[] res = new int[2];
                res[0] = map.get(target + nums[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            if (map.containsKey(nums[i] - target)) {
                int[] res = new int[2];
                res[0] = map.get(nums[i] - target) + 1;
                res[1] = i + 1;
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
