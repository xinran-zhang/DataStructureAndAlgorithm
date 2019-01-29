package grace.shuati;

import java.util.HashMap;
import java.util.Map;

/**
 * Give a number of arrays, find their intersection, and output their intersection size.
 */


public class IntersectionOfArrays {
    public int intersectionOfArrays(int[][] arrs) {
        int res = 0;
        if (arrs == null || arrs.length == 0 || arrs[0].length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: arrs[0]) {
            map.put(n, 1);
        }

        for (int i = 1; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                if (map.containsKey(arrs[i][j])) {
                    map.put(arrs[i][j], map.get(arrs[i][j]) + 1);
                }
            }
        }

        for (int intersection: map.keySet()) {
            if (map.get(intersection) == arrs.length) {
                res++;
            }
        }

        return res;
    }
}
