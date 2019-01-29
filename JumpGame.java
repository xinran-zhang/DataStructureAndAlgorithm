package grace.shuati;

public class JumpGame {
    public boolean canJump(int[] A) {
        // Greedy
        if (A == null || A.length == 0) {
            return false;
        }
        int farthest = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] + i >= farthest && i < farthest) {
                farthest = A[i] + i;
            }
        }

        return farthest >= A.length - 1;

        // DP
//        boolean[] can = new boolean[A.length];
//        can[0] = true;
//
//        for (int i = 1; i < A.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (can[j] && j + A[j] >= i) {
//                    can[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return can[A.length - 1];
    }
}
