package grace.shuati;

/**
 * For a given sorted array (ascending order) and a target number,
 * find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 */

public class FirstPositionOfTarget {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        else if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
