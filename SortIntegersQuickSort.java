package grace.shuati;

/**
 * Given an integer array, sort it in ascending order.
 * Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
 */

public class SortIntegersQuickSort {
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int left = start, right = end;
        // selecting a pivot number
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                right--;
                left++;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
