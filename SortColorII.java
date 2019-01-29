package grace.shuati;

/**
 * Given an array of n objects with k different colors (numbered from 1 to k),
 * sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 */

// time complexity O(nlogk)
public class SortColorII {
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int start, int end, int colorFrom, int colorTo) {
        if (colorFrom >= colorTo || start >= end) return;
        int left = start, right = end;
        int pivotColor = (colorFrom + colorTo) / 2;
        while (left <= right) {
            while (left <= right && colors[left] <= pivotColor) {
                left++;
            }
            while (left <= right && colors[right] > pivotColor) {
                right--;
            }
            if (left <= right) {
                int tmp = colors[right];
                colors[right] = colors[left];
                colors[left] = tmp;
                left++;
                right--;
            }
        }
        rainbowSort(colors, start, right, colorFrom, pivotColor);
        rainbowSort(colors, left, end, pivotColor + 1, colorTo);
    }
}
