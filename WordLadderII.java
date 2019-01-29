package grace.shuati;
import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        dict.add(start);
        dict.add(end);
        bfs(start, end, dict, distance, map);

        List<String> path = new ArrayList<>();

        dfs(start, end, dict, distance, map, path, results);

        return results;
    }

    // 把每个单词距离start的距离找出来存在distance里
    // 把字典中每个单词的前一个单词（们）存在map里
    // from start to end
    private void bfs(String start, String end, Set<String> dict,
                     Map<String, Integer> distance, Map<String, List<String>> map) {
        Queue<String> queue = new LinkedList<>();

        queue.offer(start);
        distance.put(start, 0);

        for (String s: dict) {
            map.put(s, new ArrayList<>());
        }

        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> nextWords = getNextWords(word, dict);
            for (String next: nextWords) {
                map.get(next).add(word);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(word) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    // dfs is used to record visited words
    // from end to start
    private void dfs(String start, String word, Set<String> dict, Map<String, Integer> distance,
                     Map<String, List<String>> map, List<String> path, List<List<String>> results) {
        path.add(word);
        if (word.equals(start)) {
            Collections.reverse(path);
            results.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            for (String next: map.get(word)) {
                if (distance.containsKey(next) && distance.get(word) == distance.get(next) + 1) {
                    dfs(start, next, dict, distance, map, path, results);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                if (dict.contains(replace(word, i, c))) {
                    res.add(replace(word, i, c));
                }
            }
        }
        return res;
    }
}
