class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i])
                continue;

            int[] count = new int[2];

            dfs(i, graph, visited, count);

            int nodes = count[0];
            int edgeCount = count[1] / 2;

            int requiredEdges = nodes * (nodes - 1) / 2;

            if (edgeCount == requiredEdges) {
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int node,
                     List<List<Integer>> graph,
                     boolean[] visited,
                     int[] count) {

        visited[node] = true;

        // Count vertices
        count[0]++;

        // Count edges
        count[1] += graph.get(node).size();

        for (int next : graph.get(node)) {

            if (!visited[next]) {
                dfs(next, graph, visited, count);
            }
        }
    }
}