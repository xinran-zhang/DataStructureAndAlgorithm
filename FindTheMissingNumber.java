package grace.shuati;

/**
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 */

public class FindTheMissingNumber {
    public int findMissing(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (1 + nums.length) * nums.length / 2 - sum;
    }
}
