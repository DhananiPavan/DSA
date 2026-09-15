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
        boolean[] v = new boolean[points.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        int sum = 0;
        int count = 0;
        // Start with node 0 at cost 0
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curnode = cur.node;
            int curw = cur.weight;
            if (v[curnode]) {
                continue;
            }
            v[curnode] = true;
            sum += curw;
            int i = -1;

            for (int[] arr : points) {
                i++;
                if (i == curnode || v[i])
                    continue;

                int val = Math.abs(points[curnode][0] - arr[0]) + Math.abs(points[curnode][1] - arr[1]);
                pq.add(new Pair(i, val));

            }
        }
        return sum;

    }
}