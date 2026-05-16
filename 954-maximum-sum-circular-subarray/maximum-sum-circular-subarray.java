class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int max=Integer.MIN_VALUE;
       int min=nums[0];
       int n=nums.length;
       int cur=0;
       int total=0;
       boolean t=false;
       for(int i=0;i<n;i++){
          cur=Math.max(cur+nums[i],nums[i]);
          max=Math.max(max,cur);
          total+=nums[i];
          
       }
       cur=nums[0];
       for(int i=1;i<n;i++){
        cur=Math.min(cur+nums[i],nums[i]);
        min=Math.min(min,cur);
        
       }
       if(max<0){
        return max;
       }
       return  Math.max(max,total-min);


    }
}