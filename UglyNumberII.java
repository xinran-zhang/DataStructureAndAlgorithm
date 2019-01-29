package grace.shuati;
import java.util.*;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        // use a priorityqueue to maintain the ugly numbers, starting from 1
        // poll out 1, put in 1 * 2, 3, and 5
        // use a set to track if the num has been used
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        pq.offer((long) 1);
        visited.add((long) 1);
        int count = 0;

        while (!pq.isEmpty()) {
            long num = pq.poll();
            count++;
            if (count == n) {
                return (int)num;
            }
            if (!visited.contains(num * 2)) {
                pq.offer(num * 2);
                visited.add(num * 2);
            }
            if (!visited.contains(num * 3)) {
                pq.offer(num * 3);
                visited.add(num * 3);
            }
            if (!visited.contains(num * 5)) {
                pq.offer(num * 5);
                visited.add(num * 5);
            }
        }
        return -1;
    }
}
