package grace.shuati;

public class SubarraySum2 {
    // helper method -> find the number of integers that are smaller than target in an int array
    private int findSmallerThanTarget(int[] sum, int target) {
        int start = 0, end = sum.length - 1;
        if (sum[end] < target) {
            return end + 1;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sum[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public int subarraySumII(int[] A, int start, int end) {
        int[] sum = new int[A.length + 1];
        sum[0] = 0;
        for (int i = 1; i < A.length + 1; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        int res = 0;
        for (int i = 1; i < A.length + 1; i++) {
            int left = sum[i] - end;
            int right = sum[i] - start + 1;
            res += findSmallerThanTarget(sum, right) - findSmallerThanTarget(sum, left);
        }
        return res;
//        int count = 0;
//        int[][] matrix = new int[A.length][A.length];
//        for (int i = 0; i < A.length; i++) {
//            matrix[i][i] = A[i];
//            if (matrix[i][i] >= start && matrix[i][i] <= end) {
//                count++;
//            }
//        }
//
//        // calculate the sum of all subarrays and put them to matrix
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length; j++) {
//                matrix[i][j] = matrix[i][j - 1] + A[j];
//                if (matrix[i][j] >= start && matrix[i][j] <= end) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
    }
}
