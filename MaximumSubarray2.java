package grace.shuati;
import java.util.*;

public class MaximumSubarray2 {
    public int maxTwoSubArrays(List<Integer> nums) {
        int size = nums.size();
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        // find the largest subarray forward
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMax[i] = max;
        }

        // find the largest subarray backward
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[i] = max;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            maxSum = Math.max(maxSum, leftMax[i] + rightMax[i + 1]);
        }
        return maxSum;
    }
}
