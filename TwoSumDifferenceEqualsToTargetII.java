package grace.shuati;

// time complexity O(n2)
public class TwoSumDifferenceEqualsToTargetII {
    public int[] twoSum7(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == Math.abs(target)) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return new int[0];
    }
}
