package grace.shuati;

/**
 * Partition an unsorted integer array into three parts:
 * The front part < low
 * The middle part >= low & <= high
 * The tail part > high
 * Return any of the possible solutions.
 */

// three pointers
// one pointer -> start from left
// one pointer -> start from right
// one pointer -> start from 0, if num < low, swap with left, if > high, swap with right, else move 1 step
public class PartitionArrayII {
    public void partition2(int[] nums, int low, int high) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (nums[i] < low) {
                swap(nums, i, left);
                i++;
                left++;
            } else if (nums[i] > high) {
                swap(nums, i, right);
                right--;
                i++;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
