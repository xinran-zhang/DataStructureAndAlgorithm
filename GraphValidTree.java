package grace.shuati;
import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // use a map to visualize relationship between int and its connected ints
        // start from the first element in the edges
        // gradually offer the next level int to queue
        // if any new next level int has been visited, return false
        // return true
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }


        Queue<Integer> queue = new LinkedList<>();
        // track all visited ints
        Set<Integer> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = initializeMap(n, edges);

        queue.offer(0);
        set.add(0);

        while (!queue.isEmpty()) {
            int curInt = queue.poll();
            for (int nextInt: map.get(curInt)) {
                if (set.contains(nextInt)) {
                    continue;
                }
                queue.offer(nextInt);
                set.add(nextInt);
            }
        }

        return (set.size() == n);
    }

    private Map<Integer, Set<Integer>> initializeMap (int n, int[][] edges) {
        Map<Integer, Set<Integer>> results = new HashMap<>();
        for (int i = 0; i < n; i++) {
            results.put(i, new HashSet<>());
        }

        for (int[] pair: edges) {
            for (int i = 0; i <= 1; i++) {
                results.get(pair[i]).add(pair[1 - i]);
            }
        }
        return results;
    }
}
