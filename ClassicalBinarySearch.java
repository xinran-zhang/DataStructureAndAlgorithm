package grace.shuati;

/**
 * Find any position of a target number in a sorted array. Return -1 if target does not exist.
 */

// use recursion
public class ClassicalBinarySearch {
    public int findPosition(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        }
        return binarySearch(nums, mid + 1, end, target);
    }
}
