package grace.shuati;

public class NumArray2 {
    int[] sum;
    public NumArray2(int[] nums) {
        sum = new int[nums.length];
        for (int i = 0; i < sum.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }
}
