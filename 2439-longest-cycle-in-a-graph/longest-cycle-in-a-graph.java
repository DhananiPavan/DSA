import java.util.*;

class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] inDegree = new int[n];

        // Step 1: Calculate in-degree for each node
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                inDegree[edges[i]]++;
            }
        }

        // Step 2: Use a queue to remove all non-cycle nodes (in-degree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 3: Collect all cycle-causing nodes into a list
        List<Integer> cycleNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycleNodes.add(i);
            }
        }

        // Step 4: Run DFS on cycle-causing nodes to measure cycle lengths
        int maxLength = -1;
        for (int node : cycleNodes) {
            if (!visited[node]) {
                int cycleLength = dfs(node, edges, visited);
                maxLength = Math.max(maxLength, cycleLength);
            }
        }

        return maxLength;
    }

    private int dfs(int node, int[] edges, boolean[] visited) {
        visited[node] = true;
        int nextNode = edges[node];
        
        if (nextNode != -1 && !visited[nextNode]) {
            return 1 + dfs(nextNode, edges, visited);
        }
        
        return 1;
    }
}