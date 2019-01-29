package grace.shuati;
import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 */

public class IntersectionOfTwoArrays2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                numList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[numList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = numList.get(i);
        }
        return res;
    }
}
