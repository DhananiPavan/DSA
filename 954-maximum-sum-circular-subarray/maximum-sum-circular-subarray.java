class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int max=nums[0];
       int min=nums[0];
       int n=nums.length;
       int cur1=0;
       int cur2=0;
       int total=0;
      
       
       for(int i=0;i<n;i++){
        cur1=Math.max(cur1+nums[i],nums[i]);
        max=Math.max(max,cur1);
        total+=nums[i];
        cur2=Math.min(cur2+nums[i],nums[i]);
        min=Math.min(min,cur2);
        }
       if(max<0){
        return max;
       }
       return  Math.max(max,total-min);


    }
}