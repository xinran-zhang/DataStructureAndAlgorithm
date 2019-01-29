package grace.shuati;
import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */

/**
 * Solution idea: add the ith element in the array to all previous list
 * take [1, 2, 3] as an example:
 * first round: []
 * second round: [], [1]
 * third round: [], [1], [2], [1, 2]
 * fourth round: [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        // recursion outlet
        // 注意加入的是NEW出来的一个subset，如果把SUBSET加进去，之后修改的就是已经加入的这一个
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }

        // break down recursion
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);

        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, res);
    }
}
