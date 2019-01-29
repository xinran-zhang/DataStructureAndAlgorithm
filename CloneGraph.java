package grace.shuati;
import java.util.*;

public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // need to a queue to realize BFS
        // use a hashmap to maintain the original node and its clone <UndirectedGraphNode, UndirectedGraphNode>
        // use an arraylist to track all nodes
        if (node == null) return null;
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        // clone nodes
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            // find all nodes, start from the neighbors of the node
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode clonedNode = map.get(nodes.get(i));
            // add the neighbors of nodes.get(i) to clonedNode
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                // REMEMBER!!! but need to add the cloned copy in the map to the clonedNode
                clonedNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}
