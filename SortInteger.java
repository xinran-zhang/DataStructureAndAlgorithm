package grace.shuati;

/**
 * Given an integer array, sort it in ascending order.
 * Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.
 */

public class SortInteger {
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
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
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

        System.out.println();

        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public static void main(String[] args) {
        SortInteger test = new SortInteger();
        test.sortIntegers(new int[]{5, 3, 7, 9, 2, 0, 13, 4});
    }
}
