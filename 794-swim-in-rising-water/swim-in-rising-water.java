class Solution {
    public int swimInWater(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int[][] v = new int[grid.length][grid[0].length];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while (!pq.isEmpty()) {
            int[] pop = pq.poll();

            int w = pop[0];
            int x = pop[1];
            int y = pop[2];

            if (v[x][y] == 1) {
                continue;
            }

            v[x][y] = 1;

            ans = Math.max(ans, w);

            if (x == grid.length - 1 && y == grid.length - 1) {
                return ans;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                int n = grid.length;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (v[nx][ny] == 0) {
                    int newCost = Math.max(w, grid[nx][ny]);

                    pq.add(new int[]{newCost, nx, ny});
                }
            }
        }

        return ans;
    }
}