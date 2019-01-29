package grace.shuati;
import java.util.*;

public class TopKLargestNumbersII {
    PriorityQueue<Integer> pq;
    int n;
    public TopKLargestNumbersII(int k) {
        pq = new PriorityQueue<>();
        n = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        pq.add(num);
        if (pq.size() > n) {
            pq.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        List<Integer> topK = new ArrayList<>();
        for (int num: pq) {
            topK.add(num);
        }
        Collections.sort(topK, Collections.reverseOrder());
        return topK;
    }

}
