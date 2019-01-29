package grace.shuati;
import java.util.*;

public class BuildPostOffice {
    private int[] dx = {1, 0 , 0 , -1};
    private int[] dy = {0, 1, -1, 0};
    public int shortestDistance(int[][] grid) {
        List<int[]> empty = new ArrayList<>();
        int numOfHouse = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    numOfHouse++;
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int[] pair : empty) {
            shortest = Math.min(shortest, getDistance(grid, pair[0], pair[1], numOfHouse));
        }
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
    private int getDistance(int[][] grid, int x, int y, int numOfHouse) {
        return numOfHouse;
    }
}
