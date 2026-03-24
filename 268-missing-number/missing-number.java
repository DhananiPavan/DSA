class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=0;
        int actualTotal=((n*(n+1))/2);
        for(int x : nums){
            total+=x;
        }
        if(total!=actualTotal){
            return actualTotal-total;
            
        }
        return 0;

        
    }
}