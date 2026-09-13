class Solution {
    public int countCompleteComponents(int n1, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add all edges
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] v = new boolean[n1];
        int ans = 0;

        for (int i = 0; i < n1; i++) {
            if (v[i]) continue;

            // comp[0] = node count (n), comp[1] = total degree sum (e)
            int[] comp = new int[2];
            dfs(i, adj, comp, v);

            int nodes = comp[0];
            int totalDegrees = comp[1];

            // In a complete graph with 'nodes' vertices, total directed degree sum is nodes * (nodes - 1)
            if (totalDegrees == nodes * (nodes - 1)) {
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int i, List<List<Integer>> adj, int[] comp, boolean[] v) {
        comp[0]++; 
        v[i] = true;

        for (int nei : adj.get(i)) {
            comp[1]++; // Count degree (e)
            if (!v[nei]) {
                dfs(nei, adj, comp, v);
            }
        }
    }
}