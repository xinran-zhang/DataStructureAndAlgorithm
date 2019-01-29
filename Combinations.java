package grace.shuati;
import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k, int startIndex, List<Integer> sub, List<List<Integer>> res) {
        // this is important! need to make a deep copy of the sub
        if (sub.size() == k) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            sub.add(i);
            dfs(n, k, i + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations comb = new Combinations();
        comb.combine(4, 2);
    }
}
