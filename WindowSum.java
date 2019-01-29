package grace.shuati;

/**
 * Given an array of n integer, and a moving window(size k),
 * move the window at each iteration from the start of the array,
 * find the sum of the element inside the window at each moving.
 */

// sliding window: add the next element and remove the beginning element
public class WindowSum {
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        res[0] = sum;
        int start = 1, end = k;
        while (end < nums.length) {
            res[start] = res[start - 1] + nums[end] - nums[start - 1];
            start++;
            end++;
        }
        return res;
    }
}
