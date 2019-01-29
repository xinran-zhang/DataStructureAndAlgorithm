package grace.shuati;

/**
 * Find the kth smallest numbers in an unsorted integer array.
 */

// time complexity O(nlogn)
// use quick select to realize O(n)
public class KthSmallestNumbersInUnsortedArray {
    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (nums.length <= 1 || left >= right) {
            return;
        }
        int start = left, end = right;
        int pivot = nums[(start + end) / 2];
        while (start <= end) {
            while (start <= end && nums[start] < pivot) {
                start++;
            }
            while (start <= end && nums[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }

        quickSort(nums, left, end);
        quickSort(nums, start, right);
    }
}
