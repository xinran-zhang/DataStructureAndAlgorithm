package grace.shuati;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];
        maxProduct[0] = minProduct[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxProduct[i] = minProduct[i] = nums[i];
            if (nums[i] > 0) {
                maxProduct[i] = Math.max(maxProduct[i], maxProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(minProduct[i], minProduct[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                maxProduct[i] = Math.max(maxProduct[i], minProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(minProduct[i], maxProduct[i - 1] * nums[i]);
            }
            res = Math.max(res, maxProduct[i]);
        }

        return res;
    }
}
