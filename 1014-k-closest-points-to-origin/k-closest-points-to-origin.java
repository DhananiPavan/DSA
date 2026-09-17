import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        // dists[i][0] = squared distance
        // dists[i][1] = original index of the point
        int[][] dists = new int[n][2];

        for (int i = 0; i < n; i++) {
            dists[i][0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            dists[i][1] = i;
        }

        // Sort rows based on distance (index 0) using primitive array comparison
        Arrays.sort(dists, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int originalIndex = dists[i][1];
            ans[i] = points[originalIndex];
        }

        return ans;
    }
}