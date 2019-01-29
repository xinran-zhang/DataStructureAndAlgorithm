package grace.shuati;
import java.util.*;

public class Factorization {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return res;
    }

    private void dfs(int remain, int start) {
        if (remain == 1) {
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= Math.sqrt(remain); i++) {
            if (remain % i == 0) {
                path.add(i);
                dfs(remain / i, i);
                path.remove(path.size() - 1);
            }
        }
        // make sure remain is in the list
        path.add(remain);
        dfs(1, remain);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Factorization fact = new Factorization();
        fact.getFactors(8);
    }
}
