package grace.shuati;
import java.util.*;

/**
 * Find K-th largest element in an array. and N is much larger than k.
 */

public class KthLargestElementII {
    public int kthLargestElement2(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
