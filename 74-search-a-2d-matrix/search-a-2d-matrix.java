class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int top=0;
        int bottom=m-1;
        int row=-1;
        while(top<=bottom){
            int mid=(top+bottom)/2;
            if(matrix[mid][0]<=target && matrix[mid][n-1]>=target){
                row=mid;
                break;
            }
            else if(matrix[mid][0]>target){
                bottom=mid-1;
            }
            else{
                top=mid+1;
            }
        }
        if(row==-1)return false;
        int l=0;
        int r=n-1;
        while(l<=r)
     {
        int mid=l+(r-l)/2;
        if(matrix[row][mid]==target){
            return true;
        }
        else if(matrix[row][mid]>target){
            
             r=mid-1;

        }
        else{
           l=mid+1;
        }
     }
     return false;
    }
}