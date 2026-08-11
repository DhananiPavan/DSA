class Solution {
    public int numIslands(char[][] grid) {
       int n=grid.length;
       int m =grid[0].length;
       int numOfLands=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]=='1'){
                numOfLands++;
                dfs(grid,i,j);

            }
        }
       } 
       return numOfLands;
    }
    public void dfs(char[][] g,int r,int c){
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length) {
            return;
        }
        if (g[r][c] == '0') {
            return;
        }
        
        if(g[r][c]=='1'){
            g[r][c]='0';
        }
        dfs(g, r - 1, c);

        // Down
        dfs(g, r + 1, c);

        // Left
        dfs(g, r, c - 1);

        // Right
        dfs(g, r, c + 1);
    }
}