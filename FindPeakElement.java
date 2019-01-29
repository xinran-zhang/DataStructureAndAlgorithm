package grace.shuati;

public class FindPeakElement {
    public int findPeak(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid;
            }
            if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
                end = mid;
            }
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                end = mid;
            }
        }

        if (A[start] > A[end]) {
            return start;
        }
        return end;
    }
}
