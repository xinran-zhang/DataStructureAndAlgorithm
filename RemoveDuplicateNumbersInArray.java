package grace.shuati;
import java.util.*;

/**
 * Given an array of integers, remove the duplicate numbers in it.
 * You should:
 * 1. Do it in place in the array.
 * 2. Move the unique numbers to the front of the array.
 * 3. Return the total number of the unique numbers.
 */

// can also use a map to track the unique numbers - O(n) time;
// this method does not need extra space with O(nlogn) time complexity
public class RemoveDuplicateNumbersInArray {
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int p1 = 0, p2 = 0;
        while (p2 < nums.length) {
            if (nums[p1] != nums[p2]) {
                nums[p1 + 1] = nums[p2];
                p1++;
            }
            p2++;
        }
        return p1 + 1;
    }
}
