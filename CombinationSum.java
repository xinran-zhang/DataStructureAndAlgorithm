package grace.shuati;
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int startIndex, List<Integer> subs, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(subs));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            subs.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, subs, res);
            subs.remove(subs.size() - 1);
        }
    }
}
