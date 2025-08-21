class Solution {
    public int subarraySum(int[] nums, int k) {
   int sum=0,count=0,n=nums.length;
        for(int i=0;i<n;i++){
            sum=0;

            for(int j=i;j<n;j++){
                 sum =sum +nums[j];
                 if(sum==k){
                    count++;
                    
                   
                   

                 }


            }
        }
        return count;
        
    }
}