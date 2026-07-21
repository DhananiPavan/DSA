class Solution {
    public int maximumWealth(int[][] a) {

      int m=a.length;
      int n=a[0].length;
      int ans=0;
      for(int i=0;i<m;i++){
        int sum=0;
        for(int j=0;j<n;j++){
            sum+=a[i][j];
        }
        ans=Math.max(ans,sum);
      }
      return ans;
    }
}