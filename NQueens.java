package grace.shuati;
import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        dfs(n, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int n, List<Integer> cols, List<List<String>> results) {
        if (cols.size() == n) {
            results.add(drawChessBoard(cols));
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            dfs(n, cols, results);
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            // no duplicate num of column exists
            if (cols.get(rowIndex) == column) {
                return false;
            }
            //????
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }

    private List<String> drawChessBoard(List<Integer> cols) {
        List<String> chessBoard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                if (cols.get(i) == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            chessBoard.add(sb.toString());
        }
        return chessBoard;
    }
}
