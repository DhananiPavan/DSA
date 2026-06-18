class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        return paths(0,0,m-1,n-1,dp);
    }
    int paths(int r,int d,int m,int n,int[][] dp){
      if(r==m && d==n){
        return 1;
      }
      if(r>m ||d>n){
        return 0;
      }
      if(dp[r][d]!=0){
        return dp[r][d];
      }
      
      dp[r][d] = paths(r+1,d,m,n,dp) + paths(r,d+1,m,n,dp);
      return dp[r][d];
    }
}