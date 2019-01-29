package grace.shuati;

/**
 * Merge two given sorted integer array A and B into a new sorted integer array.
 */

public class MergeTwoSortedArrays {
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < A.length + B.length; i++) {
            if (p1 < A.length && p2 < B.length) {
                if (A[p1] <= B[p2]) {
                    res[i] = A[p1];
                    p1++;
                } else {
                    res[i] = B[p2];
                    p2++;
                }
            } else {
                if (p1 < A.length) {
                    res[i] = A[p1];
                    p1++;
                }
                if (p2 < B.length) {
                    res[i] = B[p2];
                    p2++;
                }
            }
        }
        return res;
    }
}
