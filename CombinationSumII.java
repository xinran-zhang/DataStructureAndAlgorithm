package grace.shuati;
import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 */

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null) {
            return res;
        }
        Arrays.sort(num);
        dfs(num, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[] num, int target, int startIndex, List<Integer> sub, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = startIndex; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            // avoid duplicate combinations
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
            sub.add(num[i]);
            dfs(num, target - num[i],i + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}
