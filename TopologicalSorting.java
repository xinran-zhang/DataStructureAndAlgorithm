package grace.shuati;
import java.util.*;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<DirectedGraphNode>();
    }
}

public class TopologicalSorting {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();

        // calculate the in-degree of each node and add them into a hashmap
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode neighbor: node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        // put the 0 in degree nodes into the queue and the result
        for (DirectedGraphNode node: graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                res.add(node);
            }
        }

        // pop the elements in the queue while minus 1 from its neighbors' in degree
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor: node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                // add the 0 in degree nodes into queue and result
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        return res;
    }
}
