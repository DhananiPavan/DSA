class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // 0 = not visited
        // 1 = currently in DFS path
        // 2 = safe
        // 3 = unsafe
        int[] flags = new int[n];

        for (int i = 0; i < n; i++) {

            if (dfs(i, graph, flags)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean dfs(int node, int[][] g, int[] f) {

        // Currently in DFS path -> cycle
        if (f[node] == 1) {
            return false;
        }

        // Already calculated
        if (f[node] == 2) {
            return true;
        }

        if (f[node] == 3) {
            return false;
        }

        // Terminal node
        if (g[node].length == 0) {
            f[node] = 2;
            return true;
        }

        // Mark as currently visiting
        f[node] = 1;

        for (int i = 0; i < g[node].length; i++) {

            if (!dfs(g[node][i], g, f)) {

                // This node leads to a cycle
                f[node] = 3;
                return false;
            }
        }

        // All neighbours are safe
        f[node] = 2;

        return true;
    }
}