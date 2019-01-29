package grace.shuati;

/**
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 */

// binary search
public class MaximumNumberInMountainSequence {
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.max(nums[start], nums[end]);
    }
}
