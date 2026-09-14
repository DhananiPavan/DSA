import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        // 1. Create the Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // 2. Detect the Cycle using DFS
        Set<Integer> cycleNodes = new HashSet<>();
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];

        findCycleDFS(1, 0, adj, visited, parent, cycleNodes);

        // 3. Compare the Edge List Back-to-Front
        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (cycleNodes.contains(u) && cycleNodes.contains(v)) {
                return edges[i]; // Return the first matching edge found from the back
            }
        }

        return new int[0];
    }

    private boolean findCycleDFS(int node, int par, List<List<Integer>> adj, 
                                 boolean[] visited, int[] parent, Set<Integer> cycleNodes) {
        visited[node] = true;
        parent[node] = par;

        for (int neighbor : adj.get(node)) {
            if (neighbor == par) continue;

            if (visited[neighbor]) {
                // Cycle detected: trace back from current node to neighbor using parent pointers
                int curr = node;
                cycleNodes.add(neighbor);
                while (curr != neighbor) {
                    cycleNodes.add(curr);
                    curr = parent[curr];
                }
                return true;
            }

            if (findCycleDFS(neighbor, node, adj, visited, parent, cycleNodes)) {
                return true;
            }
        }

        return false;
    }
}