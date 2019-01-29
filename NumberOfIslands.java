package grace.shuati;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a boolean 2D matrix, 0 is represented as the sea,
 * 1 is represented as the island. If two 1 is adjacent, we consider them in the same island.
 * We only consider up/down/left/right adjacent.
 * Find the number of islands.
 */

// check if right and down grid is 1, if true, continue check -> use BFS in this process
    // find all 1? start from the first 1, add it to the queue
    // while queue is not empty, check right and down and add them to the queue
// if false, count++
public class NumberOfIslands {

    private static final int[][] directions = {
            {0, -1},    // left
            {0, 1},     // right
            {-1, 0},    // up
            {1, 0}      // down
    };

    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int row = grid.length, col = grid[0].length;
        // find the first 1 and add it to the queue
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == true) {
                    queue.add(new int[] {i, j});
                    grid[i][j] = false;
                    // use BFS to check the right and down
                    while (!queue.isEmpty()) {
                        int[] index = queue.poll();
                        for (int[] direction : directions) {
                            int[] newIndex = new int[]{index[0] + direction[0], index[1] + direction[1]};
                            if (newIndex[0] >= 0 && newIndex[0] < row && newIndex[1] >= 0 && newIndex[1] < col && grid[newIndex[0]][newIndex[1]]) {
                                queue.offer(newIndex);
                                grid[newIndex[0]][newIndex[1]] = false;
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }
}
