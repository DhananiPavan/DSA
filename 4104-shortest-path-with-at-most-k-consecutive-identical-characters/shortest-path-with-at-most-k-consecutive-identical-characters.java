import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> list of [v, w]
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v, w});
        }

        // Min-heap stores: [distance, u, count]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        
        // dist[u][count] stores the minimum distance to reach node u with a given consecutive count
        // Since count can range from 1 to k, we use size k + 1.
        long[][] dist = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        // Starting at node 0. 
        // Initial count for labels[0] is 1.
        pq.offer(new long[]{0, 0, 1});
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            // If we reached the destination node n - 1, return the distance
            if (u == n - 1) {
                return (int) d;
            }

            if (d > dist[u][count]) {
                continue;
            }

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int w = neighbor[1];

                int nextCount;
                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                // Check if the consecutive character constraint is satisfied
                if (nextCount <= k) {
                    if (d + w < dist[v][nextCount]) {
                        dist[v][nextCount] = d + w;
                        pq.offer(new long[]{d + w, v, nextCount});
                    }
                }
            }
        }

        // If node n - 1 cannot be reached
        return -1;
    }
}