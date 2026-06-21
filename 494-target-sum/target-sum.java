class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }
    public int solve(int[] nums,int index,int sum,int target){
        if(index==nums.length){
            if(sum==target){
                return 1;
            }
           else{
            return 0;
           }
        }
        int plus=solve(nums,index+1,nums[index]+sum,target);
        int minus=solve(nums,index+1,sum-nums[index],target);
        return plus+minus;
    }
}