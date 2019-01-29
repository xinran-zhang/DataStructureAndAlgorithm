package grace.shuati;
import java.util.*;

public class WordLadderIILeetcode {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> results = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();

        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        // get distance and map ready
        bfs(beginWord, dict, distance, map);

        // go from the endWord
        dfs(beginWord, endWord, path, distance, map, results);
        return results;
    }

    // add all words and their distance to beginWord to distance map
    // add all words and their previous words list to map
    private void bfs(String beginWord, Set<String> dict,
                     Map<String, Integer> distance, Map<String, List<String>> map) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

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

    // from end to start
    private  void dfs(String beginWord, String word, List<String> path,
                      Map<String, Integer> distance, Map<String, List<String>> map, List<List<String>> res) {
        path.add(word);
        if (word.equals(beginWord)) {
            Collections.reverse(path);
            res.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            if (!map.containsKey(word)) {
                return;
            }
            for (String prev: map.get(word)) {
                // make sure it is the shortest path
                if (distance.containsKey(prev) && distance.get(prev) + 1 == distance.get(word)) {
                    dfs(beginWord, prev, path, distance, map, res);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private List<String> getNextWords(String word, Set<String> wordList) {
        List<String> res = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                if (wordList.contains(replace(word, i, c)) && !res.contains(replace(word, i, c))) {
                    res.add(replace(word, i, c));
                }
            }
        }
        return res;
    }

    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
