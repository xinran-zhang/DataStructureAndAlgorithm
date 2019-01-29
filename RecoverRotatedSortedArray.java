package grace.shuati;
import java.util.*;

/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 */

// algorithm: rotate three times:
// [3, 4, 5, 1, 2] -> [5, 4, 3, 2, 1] -> [1, 2, 3, 4, 5]
// key is to find where the gap is and write a helper method to reverse the arrayList
public class RecoverRotatedSortedArray {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverseArray(nums, 0, i);
                reverseArray(nums, i + 1, nums.size() - 1);
                reverseArray(nums, 0, nums.size() - 1);
            }
        }
    }

    // helper method which reverse the integer array from a specific starting point and end point
    public void reverseArray(List<Integer> nums, int start, int end) {
        while (start <= end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}
