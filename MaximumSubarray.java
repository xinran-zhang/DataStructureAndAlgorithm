package grace.shuati;

/**
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 */

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        // build a prefixSum array
        // keeps 2 sums, 1 is to track the sum of the array, the other to track the minSum of the Array
        // max is the maximum of max and the difference between sum and minSum
        if (A == null || A.length == 0){
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
