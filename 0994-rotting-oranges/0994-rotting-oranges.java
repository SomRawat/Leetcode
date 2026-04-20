import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};
        int rows = grid.length, cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize queue + count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if (fresh == 0) return 0;

        int minutes = 0;

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for (int[] dir : DIRS) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1)
                        continue;

                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    fresh--;
                    rottedThisRound = true;
                }
            }

            if (rottedThisRound) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}