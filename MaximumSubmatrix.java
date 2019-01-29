package grace.shuati;

public class MaximumSubmatrix {
    public int maxSubmatrix(int[][] matrix) {
        // prefix sum of row
        // prefix sum of col
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int[][] prefixSumCol = getPrefixSumCol(matrix);
        int max = Integer.MIN_VALUE;

        for (int upperBound = 0; upperBound < n; upperBound++) {
            for (int lowerBound = upperBound; lowerBound < n; lowerBound++) {
                int[] arr = compression(upperBound, lowerBound, prefixSumCol);
                max = Math.max(max, getMaxArray(arr));
            }
        }
        return max;
    }

    private int getMaxArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;
        for (int i: arr) {
            sum += i;
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }

    private int[] compression(int upperBound, int lowerBound, int[][] prefixSumCol) {
        int[] res = new int[prefixSumCol.length];
        for (int i = 0; i < prefixSumCol[0].length; i++) {
            res[i] = prefixSumCol[lowerBound + 1][i] - prefixSumCol[upperBound][i];
        }
        return res;
    }

    private int[][] getPrefixSumCol(int[][] matrix) {
        int[][] prefixSumCol = new int[matrix.length + 1][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                prefixSumCol[i + 1][j] = prefixSumCol[i][j] + matrix[i][j];
            }
        }
        return prefixSumCol;
    }
}
