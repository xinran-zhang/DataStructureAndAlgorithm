package grace.shuati;
import java.util.*;

public class SubmatrixSum {
    public int[][] submatrixSum(int[][] matrix) {
        int[][] res = new int[2][2];
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int[][] sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < sumMatrix.length; i++) {
            sumMatrix[i][0] = 0;
        }
        for (int i = 0; i < sumMatrix[0].length; i++) {
            sumMatrix[0][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sumMatrix[i + 1][j + 1] = sumMatrix[i][j + 1] + sumMatrix[i + 1][j] + matrix[i][j] - sumMatrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j <= matrix.length; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = 0; k <= matrix[0].length; k++) {
                    int subSum = sumMatrix[j][k] - sumMatrix[i][k];
                    if (map.containsKey(subSum)) {
                        res[0][0] = i;
                        res[0][1] = map.get(subSum);
                        res[1][0] = j - 1;
                        res[1][1] = k - 1;
                        return res;
                    } else {
                        map.put(subSum, k);
                    }
                }
            }
        }
        return res;
    }
}
