class Solution {
    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] v = new boolean[n];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        pq.add(new Pair(0, 0));

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            Pair cur = pq.poll();

            int curnode = cur.node;
            int curw = cur.weight;

            // Already connected
            if (v[curnode]) {
                continue;
            }

            // Add this point to MST
            v[curnode] = true;
            sum += curw;
            count++;

            // Connect current point to every unvisited point
            for (int i = 0; i < n; i++) {

                if (!v[i]) {
                    int distance =
                        Math.abs(points[curnode][0] - points[i][0])
                        + Math.abs(points[curnode][1] - points[i][1]);

                    pq.add(new Pair(i, distance));
                }
            }
        }

        return sum;
    }
}