class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {

            
             if (matrix[row][col] > target) {
                col--;
            }
            else if(matrix[row][col] < target) {
                row++;
            }
            else{
                return true;
            }
        }

        return false;
    }
}