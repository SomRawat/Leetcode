class Solution {
    public int minCost(int[][] grid) {
           int m = grid.length;
        int n = grid[0].length;
        
        // Directions: right, left, down, up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // Deque for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 0}); // {row, col, cost}
        
        // Visited array
        int[][] visited = new int[m][n];
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);
        visited[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int x = curr[0], y = curr[1], cost = curr[2];

            // If we reach the bottom-right corner, return the cost
            if (x == m - 1 && y == n - 1) {
                return cost;
            }

            // Explore all 4 directions
            for (int d = 0; d < 4; d++) {
                int newX = x + directions[d][0];
                int newY = y + directions[d][1];
                int newCost = cost + (grid[x][y] == d + 1 ? 0 : 1);

                // Check bounds and if the new cost is better
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && newCost < visited[newX][newY]) {
                    visited[newX][newY] = newCost;
                    if (grid[x][y] == d + 1) {
                        deque.offerFirst(new int[]{newX, newY, newCost}); // No cost, high priority
                    } else {
                        deque.offerLast(new int[]{newX, newY, newCost}); // Cost 1, low priority
                    }
                }
            }
        }
        
        return -1;
    }
}