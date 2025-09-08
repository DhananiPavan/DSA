
class Solution {
    public boolean search(int[] nums, int target) {
    
    int n=nums.length;
    int l=0;
    int h=n-1;
    while(l<=h){
        int m=(l+h)/2;
        if(nums[m]==target)
        {
            return true;
        }

        if(nums[m]==nums[l]&& nums[m]==nums[h]){
            l=l+1;
            h=h-1;
            continue;
        }
         if(nums[m]>=nums[l]){
            if(nums[l]<=target && nums[m]>=target){
                h=m-1;


            }
            else{
                l=m+1;
            }
        }
        else{
            if(nums[m]<=target && nums[h]>=target){
              l=m+1;
            }
            else{
                h=m-1;
            }
        }
        

     



    }
    return false;
    }



        
    
}