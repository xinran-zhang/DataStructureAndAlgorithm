package grace.shuati;

/**
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 */

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[] {-1, -1};
        }
        // search for the first position of target
        int start = 0, end = A.length - 1;
        int firstPos = -1, lastPos = -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            }
            if (A[mid] < target) {
                start = mid;
            }
        }
        if (A[start] != target && A[end] != target) {
            return new int[] {-1, -1};
        }
        else if (A[start] == target) {
            firstPos = start;
        } else if (A[end] == target) {
            firstPos = end;
        }
        // search for the last position of the target
        start = firstPos;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            }
            if (A[mid] <= target) {
                start = mid;
            }
        }
        if (A[end] == target) {
            lastPos = end;
        }
        else if (A[start] == target) {
            lastPos = start;
        }
        return new int[] {firstPos, lastPos};
    }
}
