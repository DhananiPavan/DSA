class Solution {
    public int climbStairs(int n) {
         int[] dp =new int[n];   
        return ways(n,dp);
        
    }
    int ways(int n,int[] dp){
        if(n<=2){
            return n;
        }
        if(dp[n-1]!=0){
            return dp[n-1];
        }
        dp[n-1]=ways(n-1,dp)+ways(n-2,dp);
        return dp[n-1];
    }
}