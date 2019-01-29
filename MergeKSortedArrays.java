package grace.shuati;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given k sorted integer arrays, merge them into one sorted array.
 */
class Element implements Comparable<Element> {
    int value;
    int x;
    int y;
    public Element(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Element o) {
        return this.value - o.value;
    }
}

public class MergeKSortedArrays {


    public int[] mergekSortedArrays(int[][] arrays) {
        Queue<Element> pq = new PriorityQueue<>();
        int totalSize = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element ele = new Element(arrays[i][0], i, 0);
                pq.offer(ele);
                totalSize += arrays[i].length;
            }
        }
        int[] results = new int[totalSize];
        int index = 0;
        while (!pq.isEmpty()) {
            Element curElement = pq.poll();
            results[index] = curElement.value;
            index++;
            if (curElement.y + 1 < arrays[curElement.x].length) {
                curElement.y = curElement.y + 1;
                curElement.value = arrays[curElement.x][curElement.y];
                pq.offer(curElement);
            }
        }
        return results;
    }
}
