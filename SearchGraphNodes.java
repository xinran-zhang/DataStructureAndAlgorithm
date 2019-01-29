package grace.shuati;
import java.util.*;

public class SearchGraphNodes {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // loop through values in the map, find the target num and its corresponding node
        // if not found, return null
        // if found several, check the distance between these node and the given node
        Set<UndirectedGraphNode> potentialNodes = new HashSet<>();
        for (UndirectedGraphNode n: graph) {
            if (values.get(n) == target) {
                potentialNodes.add(n);
            }
        }
        if (potentialNodes.size() == 0) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curNode = queue.poll();
                for (UndirectedGraphNode n: curNode.neighbors) {
                    if (potentialNodes.contains(n)) {
                        return n;
                    }
                    queue.offer(n);
                }
            }
        }
        // havent checked the node itself so if the exact node is not found in its neighbours, return the node itself
        return node;
    }
}
