package grace.shuati;
import javafx.scene.layout.Priority;

import java.util.*;

/**
 * Given a list of words and an integer k, return the top k frequent words in the list.
 */

public class TopKFrequentWords {
    class Pair {
        String word;
        int freq;
        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public String[] topKFrequentWords(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(map.size(), new Comparator<Pair>() {
            @Override
            public int compare(Pair left, Pair right) {
                if (left.freq != right.freq) {
                    return right.freq - left.freq;
                }
                return left.word.compareTo(right.word);
            }
        });
        for (String word: map.keySet()) {
            pq.offer(new Pair(word, map.get(word)));
        }
        String[] res = new String[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().word;
        }
        return res;
    }
}
