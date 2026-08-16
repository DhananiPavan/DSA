class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
         int[] flags = new int[n];
          for (int i = 0; i < n; i++) {
            if (flags[i] == 0) {
                if (!dfs(i, graph, flags, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, int[][] g, int[] f,int color){
        if(f[node]==color){
            return true;
        }
        if(f[node]!=0){
            return false;
        }
        f[node]=color;
        int c=(color==1)?2:1;
         for (int next : g[node]) {

            // Neighbor should have opposite color
            if (!dfs(next, g, f, c)) {
                return false;
            }
        }
        return true;

    }
}