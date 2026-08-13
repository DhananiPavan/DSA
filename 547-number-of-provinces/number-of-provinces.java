class Solution {
    public int findCircleNum(int[][] c) {
        boolean[] b=new boolean[c.length];
        int ans=0;
        for(int i=0;i<c.length;i++){
           if(b[i]==false){
            ans++;
            dfs(i,c,b);
           }
        }

        return ans;
    }
    public void dfs(int node ,int[][] c,boolean[] b){
        if(b[node]==true){
            return;
        }
        b[node]=true;
        for(int i =0;i<c[node].length;i++){
            if(c[node][i]==1 ){
              dfs(i,c,b);
            }
        }
    }
}