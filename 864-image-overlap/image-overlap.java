class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        // Iterate through all possible row and column translations
        for (int rShift = -n + 1; rShift < n; rShift++) {
            for (int cShift = -n + 1; cShift < n; cShift++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, rShift, cShift, n));
            }
        }

        return maxOverlap;
    }

    private int countOverlap(int[][] img1, int[][] img2, int rShift, int cShift, int n) {
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int shiftedR = r + rShift;
                int shiftedC = c + cShift;
                
                // Ensure shifted coordinates are valid indices in img1
                if (shiftedR >= 0 && shiftedR < n && shiftedC >= 0 && shiftedC < n) {
                    if (img1[shiftedR][shiftedC] == 1 && img2[r][c] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}