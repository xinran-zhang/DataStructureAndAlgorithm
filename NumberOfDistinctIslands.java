package grace.shuati;
import java.util.*;

public class NumberOfDistinctIslands {
    private int[] dx = {1, 0 , 0 , -1};
    private int[] dy = {0, 1 , -1 , 0};
    public int numberofDistinctIslands(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> translatedIsland = new HashSet<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    StringBuilder shape = new StringBuilder();
                    while (!queue.isEmpty()) {
                        int[] index = queue.poll();
                        shape.append('0');
                        grid[index[0]][index[1]] = 0;
                        for (int k = 0; k < 4; k++) {
                            int adjx = dx[k] + index[0];
                            int adjy = dy[k] + index[1];
                            if (isValid(grid, adjx, adjy) && grid[adjx][adjy] == 1) {
                                queue.offer(new int[] {adjx, adjy});
                                if (dx[k] == 1) {
                                    shape.append('1');
                                }
                                if (dx[k] == -1) {
                                    shape.append('4');
                                }
                                if (dy[k] == 1) {
                                    shape.append('2');
                                }
                                if (dy[k] == -1) {
                                    shape.append('3');
                                }
                                grid[adjx][adjy] = 0;
                            }
                        }
                    }
                    if (!translatedIsland.contains(shape.toString())) {
                        translatedIsland.add(shape.toString());
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return true;
    }
}
