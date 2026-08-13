class Solution {
    Set<Integer> set = new HashSet<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        List<Integer> ans = new ArrayList<>();
        boolean[] flags = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (dfs(i, graph, flags)) {
                ans.add(i);
                set.add(i);

            }
        }

        return ans;

    }

    public boolean dfs(int node, int[][] g, boolean[] f) {

        if (f[node] == true) {
            return false;
        }
        if(set.contains(node)){
            return true;
        }
        if (g[node].length == 0) {
              set.add(node);
            return true;
        }
        f[node] = true;
        // boolean p = true;
        for (int i = 0; i < g[node].length; i++) {
            
            if (!dfs(g[node][i], g, f)) {
                f[node]=false;
                return false;
            }

        }
        f[node]=false;
        set.add(node);
        return true;
    }
}