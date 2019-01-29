package grace.shuati;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 * Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels,
 * return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 */

// find the upper lower right and left most 1

public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        // binary search columns to the right of y while loop through the entire col to find 1 => find the right boundary
        int start = y, end = image[0].length - 1;
        int upper = x, lower = x, left = y, right = y;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // if there is 1 in col mid, start = mid, else end = mid
            if (existOneCol(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (existOneCol(image, end)) {
            right = end;
        }
        else if (existOneCol(image, start)) {
            right = start;
        }

        // binary search to find the left boundary
        start = 0;
        end = y;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // if there is 1 in col mid, end = mid, else start = mid
            if (existOneCol(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (existOneCol(image, start)) {
            left = start;
        }

        else if (existOneCol(image, end)){
            left = end;
        }

        // binary search to find the upper bound
        start = 0;
        end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // if there is 1 in row mid, end = mid, else start = mid
            if (existOneRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (existOneRow(image, start)) {
            upper = start;
        }
        else if (existOneRow(image, end)) {
            upper = end;
        }

        // binary search to find the lower bound
        start = x;
        end = image.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // if there is 1 in row mid, start = mid, else end = mid
            if (existOneRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (existOneRow(image, end)) {
            lower = end;
        }
        else if (existOneRow(image, start)) {
            lower = start;
        }

        int l1 = right - left + 1;
        int l2 = lower - upper + 1;
        return l1 * l2;
    }

    private boolean existOneCol (char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean existOneRow (char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                return true;
            }
        }
        return false;
    }
}
