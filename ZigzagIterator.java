package grace.shuati;
import java.util.*;

public class ZigzagIterator {
    Queue<Integer> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        int i = 0, j = 0;
        while (i < v1.size() && j < v2.size()) {
            queue.add(v1.get(i));
            i++;
            queue.add(v2.get(j));
            j++;
        }
        if (i < v1.size()) {
            while (i < v1.size()) {
                queue.add(v1.get(i++));
            }
        }
        if (j < v2.size()) {
            while (j < v2.size()) {
                queue.add(v2.get(j++));
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        return queue.poll();
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        if (queue.isEmpty()) {
            return false;
        }
        return true;
    }
}
