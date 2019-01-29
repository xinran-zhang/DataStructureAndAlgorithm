package grace.shuati;
import java.util.*;

public class SubarraySumClosest {
    class Pair {
        int sum;
        int index;
        public Pair (int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Pair[] prefixSum = new Pair[nums.length + 1];
        prefixSum[0] = new Pair(0, 0);
        int prev = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = new Pair(prev + nums[i - 1], i);
            prev = prefixSum[i].sum;
        }
        Arrays.sort(prefixSum, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k < prefixSum.length; k++) {
            if (ans > prefixSum[k].sum - prefixSum[k - 1].sum) {
                ans = prefixSum[k].sum - prefixSum[k - 1].sum;
                int[] tmp = new int[] {prefixSum[k].index - 1, prefixSum[k - 1].index - 1};
                Arrays.sort(tmp);
                res[0] = tmp[0] + 1;
                res[1] = tmp[1];
            }
        }
        return res;
    }
}
