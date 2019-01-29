package grace.shuati;
import java.util.*;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        // find all words that only 1 char difference from start
        // pop from queue, if the new word is in the dict, add to the queue
        // ...
        // if change one char and the word becomes end, return count
        if (dict == null) return 0;
        if (start.equals(end)) return 1;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int count = 1;

        dict.add(start);
        dict.add(end);

        queue.offer(start);
        set.add(start);

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String s: getNextWords(word, dict)) {
                    if (set.contains(s)) continue;
                    if (s.equals(end)) return count;
                    queue.offer(s);
                    set.add(s);
                }
            }
        }
        return 0;
    }

    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    // get list of words next of word and in the dict
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) continue;
                if (dict.contains(replace(word, i, c))) {
                    res.add(replace(word, i, c));
                }
            }
        }
        return res;
    }
}
