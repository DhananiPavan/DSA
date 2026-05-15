class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] prefix=new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                prefix[i][j]=mat[i-1][j-1]+prefix[i-1][j]
                +prefix[i][j-1]-prefix[i-1][j-1];
            }
        }

        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1=Math.max(i-k,0);
                int c1=Math.max(j-k,0);
                int r2=Math.min(i+k,m-1);
                int c2=Math.min(j+k,n-1);
                r1++;
                r2++;
                c1++;
                c2++;
                ans[i][j]=prefix[r2][c2]-prefix[r1-1][c2]-prefix[r2][c1-1]
                +prefix[r1-1][c1-1];
            }
        }
        return ans;
    }
}