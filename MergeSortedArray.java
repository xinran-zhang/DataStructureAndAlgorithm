package grace.shuati;

public class MergeSortedArray {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // start from A[m + n - 1]
        int pA = m - 1;
        int pB = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (pA < 0) {
                A[i] = B[pB];
                pB--;
            } else if (pB < 0) {
                A[i] = A[pA];
                pA--;
            } else if (B[pB] < A[pA]) {
                A[i] = A[pA];
                pA--;
            } else {
                A[i] = B[pB];
                pB--;
            }
        }
    }
}
