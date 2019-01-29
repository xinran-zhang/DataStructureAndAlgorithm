package grace.shuati;
import java.util.*;

public class MergeKSortedIntervalList {
    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }

    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // put all intervals into a result list first
    // need to track certain row to get the next interval so need a class called pair
    // merge the result list
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        int k = intervals.size();
        List<Interval> result = new ArrayList<>();
        Queue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return intervals.get(o1.row).get(o1.col).start - intervals.get(o2.row).get(o2.col).start;
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).size() > 0) {
                pq.offer(new Pair(i, 0));
            }
        }

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            result.add(intervals.get(pair.row).get(pair.col));
            pair.col++;
            if (pair.col < intervals.get(pair.row).size()) {
                pq.offer(new Pair(pair.row, pair.col));
            }
        }

        return merge(result);
    }

    private List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // kickoff the last interval
        result.add(new Interval(start, end));

        return result;
    }

}
