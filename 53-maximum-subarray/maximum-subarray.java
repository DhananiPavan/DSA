class Solution {
    public int maxSubArray(int[] a) {
     int max=Integer.MIN_VALUE;
     int sum=0;
     for(int i=0;i<a.length;i++){
        sum=sum+a[i];
        max=Math.max(max,sum);
        sum=(sum<0)?0:sum;
     } 
     return max;  
    }
}