package grace.shuati;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // loop through the nums
        // the pointer points to zero
        // once find a non-zero, swap with zero
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = tmp;
                pointer++;
            }
        }
    }
}
