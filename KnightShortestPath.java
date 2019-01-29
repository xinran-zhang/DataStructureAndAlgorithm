package grace.shuati;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;



// a queue to realize BFS
// need a point to maintain all points visited
// need a count to count the number of levels
// add the source point to queue first
// find all points that are the next step for source, add to queue
public class KnightShortestPath {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private static final int[][] direction = {
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2},
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1}
    };

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        Queue<Point> queue = new LinkedList<>();
        int count = 0;

        queue.offer(source);

        while(!queue.isEmpty()) {
            // find all next steps for the point
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) return count;
                for (int[] pair: direction) {
                    Point p = new Point(point.x + pair[0], point.y + pair[1]);
                    if (p.x >= 0 && p.x < grid.length && p.y >= 0 && p.y < grid[0].length && !grid[p.x][p.y]) {
                        queue.offer(p);
                        grid[p.x][p.y] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
