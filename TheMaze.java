package grace.shuati;
import java.util.*;

public class TheMaze {
    private int[] dx = {1, 0 , 0 , -1};
    private int[] dy = {0, 1, -1, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            if (index[0] == destination[0] && index[1] == destination[1] && couldStop(maze, index)) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int adjx = dx[i] + index[0];
                int adjy = dy[i] + index[1];
                if (isValid(maze, adjx, adjy) && maze[adjx][adjy] == 0 && visited[adjx][adjy] == false) {
                    queue.offer(new int[] {adjx, adjy});
                    visited[adjx][adjy] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return false;
        }
        return true;
    }

    private boolean couldStop(int[][] maze, int[] index) {
        int row = maze.length;
        int col = maze[0].length;
        for (int i = 0; i < 4; i++) {
            int adjx = dx[i] + index[0];
            int adjy = dy[i] + index[1];
            if (isValid(maze, adjx, adjy) && maze[adjx][adjy] == 1) {
                return true;
            }
        }
        if (index[0] == row - 1 || index[1] == col - 1) {
            return true;
        }
        return false;
    }
}
