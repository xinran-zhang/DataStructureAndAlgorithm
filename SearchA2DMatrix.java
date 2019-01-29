package grace.shuati;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */


// find which row it is in
// binary search the row
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;


        int r = 0;

        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[end][0] == target || matrix[start][0] == target) {
            return true;
        }
        else if (matrix[start][0] <= target && matrix[start][col - 1] >= target) {
            r = start;
        }
        else if (matrix[end][0] <= target && matrix[end][col - 1] >= target) {
            r = end;
        } else {
            return false;
        }


        start = 0;
        end = col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[r][mid] == target) {
                return true;
            }
            if (matrix[r][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[r][start] == target || matrix[r][end] == target) {
            return true;
        }
        return false;
    }
}
