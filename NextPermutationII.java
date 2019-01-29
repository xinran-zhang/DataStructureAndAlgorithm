package grace.shuati;

public class NextPermutationII {
    public void nextPermutation(int[] nums) {
        // start from the end, find the number that is larger than its prev number -> mark as nums[n]
        // find the number (start from end) that is greater than nums[n - 1] -> mark as largeNum
        // swap largeNum and nums[n - 1]
        // reverse numbers from index n to the end
        if (nums.length <= 1) {
            return;
        }
        int n = nums.length - 1;
        while (n >= 1 && nums[n] <= nums[n - 1]) {
            n--;
        }

        if (n != 0) {
            int largeIndex = getLargerThanTarget(nums, nums[n - 1], nums.length - 1);
            swap(nums, largeIndex, n - 1);
        }
        reverse(nums, n, nums.length - 1);
    }

    private int getLargerThanTarget(int[] nums, int target, int end) {
        while (nums[end] <= target) {
            end--;
        }
        return end;
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}
