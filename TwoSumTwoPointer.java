package grace.shuati;
import java.util.*;

// using two pointer

public class TwoSumTwoPointer {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[] {nums[start], nums[end]};
            }
            if (nums[start] + nums[end] < target) {
                start++;
            }
            if (nums[start] + nums[end] > target) {
                end--;
            }
        }
        return null;
    }
}
