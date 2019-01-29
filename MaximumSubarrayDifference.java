package grace.shuati;

public class MaximumSubarrayDifference {
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] maxRight = new int[size];
        int[] maxLeft = new int[size];
        int[] minRight = new int[size];
        int[] minLeft = new int[size];
        int[] negativeCopy = new int[size];
        // get a negative copy of the array
        for (int i = 0; i < size; i++) {
            negativeCopy[i] = -1 * nums[i];
        }

        // search for max subarray forward
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            maxLeft[i] = max;
        }

        // search for max subarray backward
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            maxRight[i] = max;
        }

        // search for min subarray forward using the copy -> find the max subarray and its reverse is the smallest
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = 0; i < size; i++) {
            sum += negativeCopy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            minLeft[i] = -1 * max;
        }

        // search for min subarray backward
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += negativeCopy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            minRight[i] = -1 * max;
        }

        int diff = 0;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(diff, Math.abs(maxLeft[i] - minRight[i + 1]));
            diff = Math.max(diff, Math.abs(minLeft[i] - maxRight[i + 1]));
        }
        return diff;
    }
}
