package grace.shuati;

import java.util.HashMap;
import java.util.Map;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */

// using hashmap - time complexity O(n)
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        return -1;
    }

//    private int searchMax(int[] A) {
//        int start = 0, end = A.length - 1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (A[mid] >= A[start]) {
//                start = mid;
//            }
//            if (A[mid] < A[start]) {
//                end = mid;
//            }
//        }
//
//        if (A[end] > A[start]) {
//            return end;
//        }
//        return start;
//    }
}
