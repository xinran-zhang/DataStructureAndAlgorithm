package grace.shuati;

public class NumArray {
    int[] arr, bit;
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        bit = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int delta = val - arr[i];
        arr[i] = val;

        for (int j = i + 1; j <= arr.length; j = j + lowbit(j)) {
            bit[j] += delta;
        }
    }

    public int getPrefixSum(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i = i - lowbit(i)) {
            sum += bit[i];
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getPrefixSum(j) - getPrefixSum(i - 1);
    }

    private int lowbit(int x) {
        return x & (-x);
    }
}
