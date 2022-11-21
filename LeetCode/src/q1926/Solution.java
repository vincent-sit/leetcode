package q1926;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int column = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int ex = entrance[0], ey = entrance[1];
        queue.offer(new int[] { ex, ey, 0 });
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];

                if (x < 0 || x >= row || y < 0 || y >= column) {
                    if (current[0] == ex && current[1] == ey)
                        continue;
                    return current[2];
                }
                if (maze[x][y] == '.') {
                    maze[x][y] = '+';
                    queue.offer(new int[] { x, y, current[2] + 1 });
                }
            }
        }
        return -1;
    }

}
