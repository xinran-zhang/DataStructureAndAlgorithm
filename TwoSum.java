package grace.shuati;
import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

// using HashMap
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i < map.get(target - nums[i])) {
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                } else {
                    res[0] = map.get(target - nums[i]);
                    res[1] = i;
                }

            }
            map.put(nums[i], i);
        }
        return res;
    }
}
