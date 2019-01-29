package grace.shuati;
import java.util.*;

public class ConnectedComponentInUndirectedGraph {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (UndirectedGraphNode node: nodes) {
            visited.put(node, false);
        }

        for (UndirectedGraphNode node: nodes) {
            if (!visited.get(node)) {
                bfs(node, visited, res);
            }
        }
        return res;
    }

    private void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> res) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, true);
        List<Integer> subset = new ArrayList<>();

        while (!queue.isEmpty()) {
            UndirectedGraphNode n =  queue.poll();
            if (!subset.contains(n)) {
                subset.add(n.label);
            }
            for (UndirectedGraphNode neighbor: n.neighbors) {
                if (!visited.get(neighbor)) {
                    queue.offer(neighbor);
                    visited.put(neighbor, true);
                }
            }
        }
        Collections.sort(subset);
        res.add(subset);
    }
}
