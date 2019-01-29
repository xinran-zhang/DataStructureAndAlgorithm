package grace.shuati;
import java.util.*;

public class HighFive {
    class Record {
          public int id, score;
          public Record(int id, int score){
              this.id = id;
              this.score = score;
          }
     }
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < results.length; i++) {
            if (map.containsKey(results[i].id)) {
                map.get(results[i].id).add(results[i].score);
                if (map.get(results[i].id).size() > 5) {
                    map.get(results[i].id).poll();
                }
            } else {
                PriorityQueue<Integer> scores = new PriorityQueue<>();
                map.put(results[i].id, scores);
                scores.add(results[i].score);
            }
        }

        Map<Integer, Double> res = new HashMap<>();
        for (int student: map.keySet()) {
            double sum = 0;
            for (int score: map.get(student)) {
                sum += score;
            }
            res.put(student, sum / map.get(student).size());
        }
        return res;
    }
}
