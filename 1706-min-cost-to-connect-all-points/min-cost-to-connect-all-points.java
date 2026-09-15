class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.add(new int[]{0, 0});

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            int[] cur = pq.poll();

            int node = cur[0];
            int weight = cur[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sum += weight;
            count++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {

                    int distance =
                        Math.abs(points[node][0] - points[i][0])
                        + Math.abs(points[node][1] - points[i][1]);

                    pq.add(new int[]{i, distance});
                }
            }
        }

        return sum;
    }
}
