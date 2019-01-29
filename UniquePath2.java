package grace.shuati;

public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 || n == 0) {
            return 1;
        }

        int[][] uniquePath = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                uniquePath[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                uniquePath[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    uniquePath[i][j] = uniquePath[i - 1][j] + uniquePath[i][j - 1];
                } else {
                    uniquePath[i][j] = 0;
                }
            }
        }
        return uniquePath[m - 1][n - 1];
    }
}
