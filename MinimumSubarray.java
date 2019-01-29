package grace.shuati;
import java.util.*;

public class MinimumSubarray {
    public int minSubArray(List<Integer> nums) {
        if (nums.size() == 0 || nums == null) {
            return 0;
        }

        if (nums.size() == 1) {
            return nums.get(0);
        }

        List<Integer> reverse = new ArrayList<>();
        for (int num: nums) {
            reverse.add(-num);
        }

        int max = Integer.MIN_VALUE;
        int sum = 0, minSum = 0;
        for (int num: nums) {
            sum += num;
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return -max;
    }
}
