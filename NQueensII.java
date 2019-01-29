package grace.shuati;
import java.util.*;

public class NQueensII {
    public int totalNQueens(int n) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(n, new ArrayList<Integer>(), results);
        return results.size();
    }

    private void dfs(int n, List<Integer> cols, List<List<Integer>> results) {
        if (cols.size() == n) {
            results.add(new ArrayList<>(cols));
        }

        for (int col = 0; col < n; col++) {
            // check每一行的each column看是否eligible
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            dfs(n, cols, results);
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(List<Integer> cols, int col) {
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == col) {
                return false;
            }
            // cols.size() represents current row
            // cols.get(rowIndex) -> from row 0 to current row, check each row against col to see which col is eligible
            // row之间的差距等于col之间的差距时，这个col的位置是不valid的
            // check左下角
            if (cols.get(rowIndex) - col == cols.size() - rowIndex) {
                return false;
            }
            // check右下角
            if (cols.get(rowIndex) - col == rowIndex - cols.size()) {
                return false;
            }
        }
        return true;
    }
}
