import java.util.Arrays;

class Solution {
    public boolean check(int[] a) {
        int n = a.length;
        int count = 0;

        // Count how many times order is broken
        for (int i = 0; i < n; i++) {
            if (a[i] > a[(i + 1) % n]) {
                count++;
            }
        }

        // If order is broken more than once, it is not sorted & rotated
        return count <= 1;
    }
}
