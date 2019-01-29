package grace.shuati;

public class RangSumQuery2DImmutable {
    int[][] sumMatrix;
    public RangSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    sumMatrix[i][j] = matrix[0][0];
                } else if (i == 0) {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j - 1];
                } else if (j == 0) {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i - 1][j];
                } else {
                    int sum = 0;
                    for (int k = i; k >= 0; k--) {
                        sum += matrix[k][j];
                    }
                    sumMatrix[i][j] = sumMatrix[i][j - 1] + sum;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 != 0) {
            return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1];
        }
        if (row1 != 0 && col1 == 0) {
            return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2];
        }
        if (row1 == 0 && col1 == 0) {
            return sumMatrix[row2][col2];
        }
        return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1] - sumMatrix[row1 - 1][col2] + sumMatrix[row1 - 1][col1 - 1];
    }
}
