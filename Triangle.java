package grace.shuati;

public class Triangle {
    public int minimumTotal(int[][] triangle) {
        int[] minPath = new int[triangle.length];
        minPath[0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = triangle[i].length - 1; j >= 0; j--) {
                if (j == 0) {
                    minPath[j] = minPath[j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    minPath[j] = minPath[j - 1] + triangle[i][j];
                } else {
                    minPath[j] = triangle[i][j] + Math.min(minPath[j], minPath[j - 1]);
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < minPath.length; i++) {
            minimum = Math.min(minimum, minPath[i]);
        }
        return minimum;

//        int[][] sum = new int[triangle.length][triangle.length];
//        if (triangle.length == 0|| triangle[0].length == 0) {
//            return -1;
//        }
//        sum[0][0] = triangle[0][0];
//        for (int i = 1; i < triangle.length; i++) {
//            sum[i][0] = sum[i - 1][0] + triangle[i][0];
//            sum[i][i] = sum[i - 1][i - 1] + triangle[i][i];
//        }
//
//        for (int i = 1; i < triangle.length; i++) {
//            for (int j = 1; j < i; j++) {
//                sum[i][j] = Math.min(sum[i - 1][j], sum[i - 1][j - 1]) + triangle[i][j];
//            }
//        }
//
//        int best = Integer.MAX_VALUE;
//        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
//            best = Math.min(best, sum[triangle.length - 1][i]);
//        }
//        return best;
    }
}
