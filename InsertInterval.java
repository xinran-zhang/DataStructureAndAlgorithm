package grace.shuati;
import java.util.*;

public class InsertInterval {
    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int index = 0;
        while (index < intervals.size() && intervals.get(index).start < newInterval.start) {
            index++;
        }
        intervals.add(index, newInterval);

        // loop through intervals
        // if start of the curInterval > end of lastInterval, add to res
        // if start of the curInterval <= end of lastInterval,
        // change the end of lastInterval to max of curInterval end and lastInterval end
        Interval preInterval = null;
        for (Interval i: intervals) {
            if (preInterval == null || i.start > preInterval.end) {
                res.add(i);
                preInterval = i;
            } else {
                preInterval.end = Math.max(i.end, preInterval.end);
            }
        }

        return res;
    }
}
