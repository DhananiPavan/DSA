class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // cost, node, flights
        pq.offer(new int[]{0, src, 0});

        dist[src][0] = 0;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int flightsTaken = curr[2];

            if (node == dst) {
                return cost;
            }

            if (flightsTaken == k + 1) {
                continue;
            }

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int price = edge[1];

                int newCost = cost + price;
                int newFlights = flightsTaken + 1;

                if (newCost < dist[next][newFlights]) {

                    dist[next][newFlights] = newCost;

                    pq.offer(new int[]{
                        newCost,
                        next,
                        newFlights
                    });
                }
            }
        }

        return -1;
    }
}