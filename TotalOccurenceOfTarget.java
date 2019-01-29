package grace.shuati;

/**
 * Given a target number and an integer array sorted in ascending order.
 * Find the total number of occurrences of target in the array.
 */

public class TotalOccurenceOfTarget {
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A[0] > target || A[A.length - 1] < target) {
            return 0;
        }

        // find the beginning position of target
        int start = 0, end = A.length - 1;
        int beginPos = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                beginPos = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (A[beginPos] != target) {
            return 0;
        }

        // find the end position of target
        start = 0;
        end = A.length - 1;
        int endPos = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                endPos = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return endPos - beginPos + 1;
    }
}
