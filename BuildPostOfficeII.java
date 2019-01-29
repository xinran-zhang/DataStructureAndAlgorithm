package grace.shuati;
import java.util.*;

// this is wrong
public class BuildPostOfficeII {
    private int[] dx = {1, 0 , 0 , -1};
    private int[] dy = {0, 1, -1, 0};
    public int shortestDistance(int[][] grid) {
        // use a queue, offer all 0 to the queue
        // write another method to find the shortest path to every house
        List<int[]> empty = new ArrayList<>();
        int numOfHouse = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty.add(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    numOfHouse++;
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int[] pair: empty) {
            shortest = Math.min(shortest, getDistance(grid, pair[0], pair[1], numOfHouse));
        }
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }

    private int getDistance(int[][] grid, int x, int y, int numOfHouse) {
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        queue.offer(new int[] {x, y});
        visited.add(new int[] {x, y});
        int count = 0;
        int distance = 0;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int j = 0; j < size; j++) {
                int[] pair = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int indexX = dx[i] + pair[0];
                    int indexY = dy[i] + pair[1];
                    if (visited.contains(new int[]{indexX, indexY})) {
                        continue;
                    }
                    if (isValid(grid, indexX, indexY)) {
                        if (grid[indexX][indexY] == 1) {
                            count++;
                            distance += steps;
                            if (count == numOfHouse) {
                                return distance;
                            }
                        } else if (grid[indexX][indexY] == 0) {
                            queue.offer(new int[] {indexX, indexY});
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return true;
    }
}
