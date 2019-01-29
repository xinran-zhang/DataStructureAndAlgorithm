package grace.shuati;
import java.util.*;

public class MergeTwoSortedIntervalList {
    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        if (list1 == null || list1.size() == 0) {
            return list2;
        }
        if (list2 == null || list2.size() == 0) {
            return list1;
        }
        int p1 = 0, p2 = 0;
        List<Interval> res = new ArrayList<>();
        Interval curInterval = null;
        Interval lastInterval = null;
        while (p1 < list1.size() && p2 < list2.size()) {
            if (list1.get(p1).start < list2.get(p2).start) {
                curInterval = list1.get(p1);
                p1++;
            } else {
                curInterval = list2.get(p2);
                p2++;
            }
            lastInterval = mergeInterval(curInterval, lastInterval, res);
        }
        while (list1.size() > p1) {
            lastInterval = mergeInterval(list1.get(p1), lastInterval, res);
            p1++;
        }
        while (list2.size() > p2) {
            lastInterval = mergeInterval(list2.get(p2), lastInterval, res);
            p2++;
        }
        if (lastInterval != null) {
            res.add(lastInterval);
        }
        return res;
    }
    // return last interval
    private Interval mergeInterval(Interval curInterval, Interval lastInterval, List<Interval> res) {
        if (lastInterval == null) {
            return curInterval;
        }
        if (curInterval.start > lastInterval.end) {
            res.add(lastInterval);
            return curInterval;
        }

        lastInterval.end = Math.max(curInterval.end, lastInterval.end);
        return lastInterval;
    }
}
