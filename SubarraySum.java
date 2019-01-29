package grace.shuati;
import java.util.*;

/**
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 */

public class SubarraySum {
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            if (nums[0] == 0) {
                res.add(0);
            }
            return res;
        }
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            if (prefixSum[i] == 0) {
                res.add(0);
                res.add(i);
                return res;
            }
        }

        // find 2 same nums in the prefixSum list
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (map.containsKey(prefixSum[i])) {
                res.add(map.get(prefixSum[i]) + 1);
                res.add(i);
                return res;
            }
            map.put(prefixSum[i], i);
        }
        return res;
    }
}
