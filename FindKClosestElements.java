package grace.shuati;

/**
 * Given a target number, a non-negative integer target and an integer array A sorted in ascending order,
 * find the k closest numbers to target in A, sorted in ascending order by the difference
 * between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
 */

public class FindKClosestElements {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int left = lowerClosestNum(A, target);
        int right = left + 1;
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                res[i] = A[left];
                left--;
            } else {
                res[i] = A[right];
                right++;
            }
        }

        return res;
    }

    // find the last element smaller than target
    private int lowerClosestNum(int[] A, int target) {
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[end] < target) {
            return end;
        }
        if (A[start] < target) {
            return start;
        }
        return -1;
    }

    // filter the left and right of lowerClosestNum for k numbers
    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0) {
            return false;
        }

        if (right >= A.length) {
            return true;
        }

        if (target - A[left] != A[right] - target) {
            return target - A[left] < A[right] - target;
        }
        return true;
    }
}
