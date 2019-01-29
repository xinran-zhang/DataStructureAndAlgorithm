package grace.shuati;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 */

// binary search
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKthSmallest(A, B, len / 2) + findKthSmallest(A, B, len/2 + 1)) / 2.0;
        }
        return findKthSmallest(A, B, len/2 + 1);
    }

    private int findKthSmallest(int[]A, int[]B, int k) {
        if (A.length == 0) {
            return B[k - 1];
        }
        if (B.length == 0) {
            return A[k - 1];
        }
        int start = Math.min(A[0], B[0]);
        int end = Math.max(A[A.length - 1], B[B.length - 1]);

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (countSmallerOrEqual(A, mid) + countSmallerOrEqual(B, mid) >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (countSmallerOrEqual(A, start) + countSmallerOrEqual(B, start) >= k) {
            return start;
        }
        return end;
    }

    private int countSmallerOrEqual(int[]A, int k) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] > k) {
            return start;
        }
        if (A[end] > k) {
            return end;
        }
        return A.length;
    }
}
