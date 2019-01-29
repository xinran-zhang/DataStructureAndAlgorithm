package grace.shuati;

/**
 * Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.
 * flip(arr, i): Reverse array from 0 to i
 */

public class PancakeSort {
    public void pancakeSort(int[] array) {
        for (int curSize = array.length; curSize > 1; curSize--) {
            int mi = findMax(array, curSize);
            if (mi != curSize - 1) {
                FlipTool.flip(array, mi);
                FlipTool.flip(array, curSize - 1);
            }
        }
    }

    public int findMax(int[] array, int n) {
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] > array[index]) {
                index = i;
            }
        }
        return index;
    }
}
