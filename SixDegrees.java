package grace.shuati;
import java.util.*;

public class SixDegrees {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // put s in the queue first, poll, add its next level friends to the queue...
        // if not found return -1
        // use a map to track which node has been visited
        if (s == t) return 0;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, Integer> visited = new HashMap<>();
        int degree = 1;

        queue.offer(s);
        visited.put(s, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++){
                UndirectedGraphNode node = queue.poll();
                for (UndirectedGraphNode nextDegree: node.neighbors) {
                    if (visited.containsKey(nextDegree)) {
                        continue;
                    }
                    visited.put(nextDegree, degree);
                    queue.offer(nextDegree);
                    if (nextDegree.equals(t)) {
                        return degree;
                    }
                }
            }
            degree++;
        }
        return -1;
    }
}
