package grace.shuati;

public class MaximumSubarrayIV {
    public int maxSubarray4(int[] nums, int k) {
        if (k > nums.length) {
            return 0;
        }
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            if (i >= k) {
                minSum = Math.min(minSum, prefixSum[i - k]);
                maxSum = Math.max(maxSum, prefixSum[i] - minSum);
            }
        }
        return maxSum;
    }
}
