package grace.shuati;
import java.util.*;

public class ZombieInMatrix {
    private static int[] dx = {1, 0 , 0 , -1};
    private static int[] dy = {0, 1, -1, 0};
    public int zombie(int[][] grid) {
        // queue is used to store position like [x, y]
        Queue<int[]> queue = new LinkedList<>();
        // since we calculate days from the initial status
        int days = -1;
        // find every zombie in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] pos = {i, j};
                    queue.offer(pos);
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] zombiePos = queue.poll();
                // check left right up and down for people and turn them to zombie, add these zombies to queue
                for (int j = 0; j < 4; j++) {
                    int adjx = zombiePos[0] + dx[j];
                    int adjy = zombiePos[1] + dy[j];
                    if (isValid(grid, adjx, adjy) && grid[adjx][adjy] == 0) {
                        grid[adjx][adjy] = 1;
                        int[] newZombie = new int[] {adjx, adjy};
                        queue.offer(newZombie);
                    }
                }
            }
            days++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return days;
    }

    private boolean isValid (int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return true;
    }
}
