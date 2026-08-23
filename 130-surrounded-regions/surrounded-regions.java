class Solution {
    public void solve(char[][] b) {
        
        int m = b.length;
        int n= b[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || j==n-1 || i==m-1)&& (b[i][j]=='O')){
                   dfs(b,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(b[i][j]=='e'){
                    b[i][j]='O';
                }
                else if(b[i][j]=='O'){
                    b[i][j]='X';
                }
            }
        }
    }

    public void dfs(char[][] b, int i, int j) {
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length || b[i][j] != 'O') {
            return;
        }
        if(b[i][j]=='X' || b[i][j]=='e'){
            return;
        }
        b[i][j]='e';
        dfs(b,i+1,j);
        dfs(b,i-1,j);
        dfs(b,i,j+1);
        dfs(b,i,j-1);
    }
}