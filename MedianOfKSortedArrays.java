package grace.shuati;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfKSortedArrays {
    private class Element implements Comparable<Element> {
        int val;
        int x;
        int y;
        public Element(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Element o) {
            return this.val - o.val;
        }
    }
    public double findMedian(int[][] nums) {
        // use a priority queue (min heap)
        // calculate the total number of nums
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        Queue<Element> pq = new PriorityQueue<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length > 0) {
                size += nums[i].length;
                Element element = new Element(nums[i][0], i, 0);
                pq.offer(element);
            }
        }
        int count = 0;
        while(!pq.isEmpty()) {
            Element el = pq.poll();
            count++;
            if (count == size / 2) {
                if (size % 2 == 0) {
                    return (el.val + pq.poll().val) / 2.0;
                } else {
                    return (double)pq.poll().val;
                }
            }
            if (el.y + 1 < nums[el.x].length) {
                el.y = el.y + 1;
                el.val = nums[el.x][el.y];
                pq.offer(el);
            }
        }

        return 0;
    }
}
