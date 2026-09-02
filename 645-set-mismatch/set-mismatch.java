class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum =0;
        int dup=0;
        
        int total=(n*(n+1))/2;
        Arrays.sort(nums);
        for(int i =0;i<n;i++){
          if(i!=0 && nums[i]==nums[i-1]){
            dup=nums[i];
            
          }
          sum=sum+nums[i];
        }
        sum=sum-dup;
        total=total-sum;
        return new int[]{dup,total};

        
        
    }
}