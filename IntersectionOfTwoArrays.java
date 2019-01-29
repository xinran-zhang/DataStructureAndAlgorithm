package grace.shuati;
import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                visited.add(nums2[j]);
            }
        }
        int[] res = new int[visited.size()];
        int index = 0;
        for (int num: visited) {
            res[index] = num;
            index++;
        }
        return res;
    }
}
