class Solution {
    public int maxSubArray(int[] a) {
     int max=Integer.MIN_VALUE;
     int cur=0;
     for(int i=0;i<a.length;i++){
        cur=cur+a[i];
        max=Math.max(max,cur);
        cur=(cur<0)?0:cur;
     } 
     return max;  
    }
}