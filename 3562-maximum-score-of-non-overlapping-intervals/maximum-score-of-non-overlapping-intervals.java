class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [left, right, weight, originalIndex]
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by right endpoint
        Arrays.sort(a, (x, y) -> {
            if (x[1] != y[1])
                return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });

        // prev[i] = first index after all intervals
        // having right < a[i][0]
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int l = 0, r = i;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (a[mid][1] < a[i][0])
                    l = mid + 1;
                else
                    r = mid;
            }

            prev[i] = l;
        }

        // dp[k][i] = best answer using at most k intervals
        // among first i intervals
        long[][] dp = new long[5][n + 1];

        // Store selected original indices
        int[][][] path = new int[5][n + 1][];

        for (int k = 1; k <= 4; k++) {

            for (int i = 1; i <= n; i++) {

                // Don't take current interval
                dp[k][i] = dp[k][i - 1];
                path[k][i] = path[k][i - 1];

                // Take current interval
                int idx = i - 1;

                long takeScore =
                    dp[k - 1][prev[idx]] + a[idx][2];

                int[] takePath =
                    add(path[k - 1][prev[idx]], a[idx][3]);

                if (takeScore > dp[k][i] ||
                    (takeScore == dp[k][i] &&
                     smaller(takePath, path[k][i]))) {

                    dp[k][i] = takeScore;
                    path[k][i] = takePath;
                }
            }
        }

        return path[4][n] == null
                ? new int[0]
                : path[4][n];
    }

    // Add index and keep indices sorted
    private int[] add(int[] old, int value) {

        if (old == null) {
            return new int[]{value};
        }

        int[] res = new int[old.length + 1];

        int i = 0;

        while (i < old.length && old[i] < value) {
            res[i] = old[i];
            i++;
        }

        res[i] = value;

        while (i < old.length) {
            res[i + 1] = old[i];
            i++;
        }

        return res;
    }

    // true if a is lexicographically smaller than b
    private boolean smaller(int[] a, int[] b) {

        if (b == null)
            return true;

        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {

            if (a[i] != b[i])
                return a[i] < b[i];
        }

        return a.length < b.length;
    }
}