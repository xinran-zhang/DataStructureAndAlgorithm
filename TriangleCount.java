package grace.shuati;

import java.util.Arrays;

/**
 * Given an array of integers, how many three numbers can be found in the array,
 * so that we can build an triangle whose three edges length is the three numbers that we find?
 */

// sum of two *smaller* nums is greater than the third one
// target start from index 0, find if there is a pair of int that its sum is greater than target
// separate method find two sums
public class TriangleCount {
    public int triangleCount(int[] S) {
        if (S ==  null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        for (int i = S.length - 1; i > 1; i--) {
            res = res + twoSum(S, 0, i - 1, S[i]);
        }
        return res;
    }

    private int twoSum(int[]nums, int start, int end, int target) {
        int count = 0;
        while (start + 1 < end) {
            if (nums[start] + nums[end] <= target) {
                start++;
            } else {
                count += (end - start);
                end--;
            }
        }
        if (nums[start] + nums[end] > target) {
            count++;
        }
        return count;
    }
}
