package grace.shuati;


// start from the bottom left corner
// if ==, can eliminate the first col and last row, count++,
// if left corner > target, eliminate last row, go to the mid of the first col
// if left corner < target, eliminate first col, go to the mid of the last row...

public class SearchA2DMatrixII {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int count = 0;
        int row = matrix.length, col = matrix[0].length;
        // bottom left - matrix[row - 1][0]
        int rowStart = row - 1, colStart = 0;
        while (rowStart>=0 && colStart <= col - 1) {
            if (target == matrix[rowStart][colStart]) {
                count++;
                rowStart--;
                colStart++;
            }
            else if (target > matrix[rowStart][colStart]) {
                colStart++;
            } else {
                rowStart--;
            }
        }

        return count;
    }
}
