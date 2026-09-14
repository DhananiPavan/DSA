class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        // Initialize each node as its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Process edges left to right
        for (int[] edge : edges) {
            int rootU = find(edge[0]);
            int rootV = find(edge[1]);

            // If both nodes already share the same root, this edge forms a cycle
            if (rootU == rootV) {
                return edge;
            }

            // Union the two components
            parent[rootU] = rootV;
        }

        return new int[0];
    }

    // Find with Path Compression
    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }
}