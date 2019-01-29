package grace.shuati;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */

public class SortColor {
    public void sortColors(int[] nums) {
        int countZero = 0, countOne = 0, countTwo = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZero++;
            if (nums[i] == 1) countOne++;
            if (nums[i] == 2) countTwo++;
        }
        for (int i = 0; i < countZero; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < countOne; i++) {
            nums[i + countZero] = 1;
        }
        for (int i = 0; i < countTwo; i++) {
            nums[i + countZero + countTwo] = 2;
        }
    }
}
