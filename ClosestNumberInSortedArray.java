package grace.shuati;

/**
 * Given a target number and an integer array A sorted in ascending order,
 * find the index i in A such that A[i] is closest to the given target.
 * Return -1 if there is no element in the array.
 */

// find if there is an exact match
// if not, find the closest number that is larger and smaller than the target
// compare these two
public class ClosestNumberInSortedArray {
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return 0;
        }

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] == target || Math.abs(A[start] - target) < Math.abs(A[end] - target)) {
            return start;
        }
        return end;
    }
}
