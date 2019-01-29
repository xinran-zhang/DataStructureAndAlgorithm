package grace.shuati;
import java.util.*;

public class KClosestPoints {
    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }
    Point globalOrigin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // use a priority queue (max heap)
        // when the size of pq gets larger than k, poll out the max point
        globalOrigin = origin;
        Queue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int diff = getDistance(globalOrigin, p2) - getDistance(globalOrigin, p1);
                if (diff == 0) {
                    diff = p2.x - p1.x;
                }
                if (diff == 0) {
                    diff = p2.y - p1.y;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int size = pq.size();
        Point[] results = new Point[size];
        for (int j = size - 1; j >= 0; j--) {
            results[j] = pq.poll();
        }
        return results;
    }

    private int getDistance(Point origin, Point point) {
        return (origin.x - point.x)*(origin.x - point.x) + (origin.y - point.y) * (origin.y - point.y);
    }
}
