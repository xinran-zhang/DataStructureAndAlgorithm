package grace.shuati;

// 找到下一个比当前数大的数的排列
public class NextPermutation {
    public int[] nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int n = nums.length - 1;
        while (n >= 1 && nums[n] <= nums[n - 1]) {
            n--;
        }
        if (n != 0) {
            // swap n-1 and nums that is greater than nums[n - 1]
            int largeIndex = findLargerThanTarget(nums, nums[n - 1], nums.length - 1);
            swap(nums, n - 1, largeIndex);
        }
        reverse(nums, n, nums.length - 1);
        return nums;
    }
    // reverse the nums from index start to index end
    private void reverse(int[] nums, int start, int end) {
        if (start > end) return;
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    // swap index i and index j
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int findLargerThanTarget(int[] nums, int target, int end) {
        while (nums[end] <= target) {
            end--;
        }
        return end;
    }
}
