class Solution {
    public int maxSubArray(int[] a) {
     int max=a[0];
     int cur=0;
     for(int i=0;i<a.length;i++){
        if(cur<0){
            cur=0;
        }
        cur=cur+a[i];
        max=Math.max(max,cur);
     } 
     return max;  
    }
}