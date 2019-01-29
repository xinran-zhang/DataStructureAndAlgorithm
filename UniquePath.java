package grace.shuati;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            sum[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }
}
