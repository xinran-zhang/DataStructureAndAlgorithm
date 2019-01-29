package grace.shuati;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array, find the top k largest numbers in it.
 */

public class TopKLargestNumbers {
    public int[] topk(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int size = pq.size();
        int[] results = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            results[i] = pq.poll();
        }
        return results;
    }
}
