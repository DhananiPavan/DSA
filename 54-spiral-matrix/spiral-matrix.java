class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = 0, lm = m - 1, rm = n - 1;
        while (l <= lm && r <= rm) {
            for (int i = r; i <= rm; i++) {
                ans.add(matrix[l][i]);
            }
            l++;
            for (int i = l; i <= lm; i++) {
                ans.add(matrix[i][rm]);
            }
            rm--;
            if (l <= lm) {
                for (int i = rm; i >= r; i--) {
                    ans.add(matrix[lm][i]);
                }
                lm--;
            }
            if (r <= rm) {
                for (int i = lm; i >= l; i--) {
                    ans.add(matrix[i][r]);
                }
                r++;
            }

        }
        return ans;
    }
}