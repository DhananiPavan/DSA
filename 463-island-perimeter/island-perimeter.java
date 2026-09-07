class Solution {
    int ans = 0;

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j) {
        
        grid[i][j] = 2;
        int[][] dir = { { +1, 0 }, { -1, 0 }, { 0, +1 }, { 0, -1 } };
        for (int[] dirs : dir) {
            
            int x = i + dirs[0];
            int y = j + dirs[1];

            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
                ans++; // Edge or water adds 1 to perimeter
            } else if (grid[x][y] == 1) {
                dfs(grid, x, y); // Recurse into unvisited land
            }
        }
    }
}