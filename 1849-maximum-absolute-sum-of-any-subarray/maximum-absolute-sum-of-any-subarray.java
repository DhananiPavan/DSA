class Solution {
    public int maxAbsoluteSum(int[] nums) {
     int n=nums.length;
     int max=Integer.MIN_VALUE;
     int min=Integer.MAX_VALUE;
     int cur=0;
     for(int i=0;i<n;i++){
        cur=Math.max(cur+nums[i],nums[i]);
        max=Math.max(max,cur);
     } 
     cur=0;  
     for(int i=0;i<n;i++){
      cur=Math.min(nums[i],cur+nums[i]);
      min=Math.min(min,cur);
     }
     return Math.max(max,Math.abs(min));
    }
}