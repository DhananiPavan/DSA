class Solution {
    public void rotate(int[][] m) {
        int [][]m1=new int[m.length][m[0].length];
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m1[j][m.length-1-i]=m[i][j];
            }
        }
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j]=m1[i][j];
            }
        }
        
    }
}