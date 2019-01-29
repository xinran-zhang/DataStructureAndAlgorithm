package grace.shuati;

/**
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 */

// using binary search
public class LastPositionOfTarget {
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            }
            if (nums[mid] > target) {
                end = mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
        }

        // check index end first since the goal is to find the last position
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
