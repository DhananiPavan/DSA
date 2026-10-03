class Solution {
    public int swimInWater(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int[][] v = new int[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // for (int[] x : cost) {
        //     Arrays.fill(x, Integer.MAX_VALUE);
        // }
        pq.add(new int[] { 0, 0, 0 });
        v[0][0] = 1;
        ans=Math.max(ans,grid[0][0]);
        int[][] dirs = new int[][] { { 0, +1 }, { 0, -1 }, { +1, 0 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            int[] pop = pq.poll();
            int w = pop[0];
            int x = pop[1];
            int y = pop[2];
            ans = Math.max(ans, grid[x][y]);
            if(x==grid.length-1 && y==grid.length-1){
                return ans;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                int n = grid.length;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue; // Skip out-of-bounds cells
                }
                
               if(v[nx][ny]==0){
                 pq.add(new int[]{grid[nx][ny],nx,ny});
                 v[nx][ny]=1;
               }


               
            }

        }
        return ans;

    }
}