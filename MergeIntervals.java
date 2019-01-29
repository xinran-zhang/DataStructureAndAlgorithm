package grace.shuati;
import java.util.*;

public class MergeIntervals{
    public class Interval{
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Interval preInterval = null;
        intervals.sort(new MyCmp());
        for (Interval interval: intervals) {
            if (preInterval == null || interval.start > preInterval.end) {
                res.add(interval);
                preInterval = interval;
            } else {
                preInterval.end = Math.max(interval.end, preInterval.end);
            }
        }
        return res;
    }

    class MyCmp implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}
