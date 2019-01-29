package grace.shuati;

public class SortedIntegerMergeSort {
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A,(start + end) / 2 + 1, end, temp);

        int leftIndex = start, rightIndex = (start + end) / 2 + 1;
        int tempIndex = leftIndex;
        while (leftIndex <= (start + end) / 2 && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[tempIndex++] = A[leftIndex++];
            } else {
                temp[tempIndex++] = A[rightIndex++];
            }
        }

        while (leftIndex <= (start + end) / 2) {
            temp[tempIndex++] = A[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[tempIndex++] = A[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}
