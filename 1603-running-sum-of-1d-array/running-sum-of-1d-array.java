class Solution {
    public int[] runningSum(int[] nums) {
         int i=0;
         int sum=0;
        for(int x:nums){
            sum+=x;
            nums[i]=sum;
            i++;
        } 
        return nums;
           
    }



}