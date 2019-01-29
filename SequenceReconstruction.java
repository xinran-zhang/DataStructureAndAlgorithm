package grace.shuati;
import java.util.*;

// topological sorting
// for each sequence in seqs, calculate the in-degree of each element
// put the element with 0 in-degree in a queue, then realize BFS
// need size to track each level -> if at each level there is only 1 element in the queue, return true
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> numSeq = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> nums = new HashSet<>();

        for (int[] sub: seqs) {
            // add all the following nums to sub[i]
            for (int i = 0; i < sub.length; i++) {
                nums.add(sub[i]);
                if (i > 0) {
                    map.put(sub[i], map.getOrDefault(sub[i], 0) + 1);
                }
                if (i < sub.length - 1) {
                    Set<Integer> set = numSeq.getOrDefault(sub[i], new HashSet<>());
                    set.add((sub[i + 1]));
                    numSeq.put(sub[i], set);
                }
            }
        }

        if (nums.size() != org.length) return false;

        // add 0 in-degree element to the queue
        for (int n: org) {
            if (!map.containsKey(n)) {
                queue.offer(n);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int num = queue.poll();
            if (!numSeq.containsKey(num)) {
                continue;
            }
            for (int element : numSeq.get(num)) {
                map.put(element, map.get(element) - 1);
                if (map.get(element) == 0) {
                    queue.offer(element);
                }
            }
        }

        return true;
    }
}
