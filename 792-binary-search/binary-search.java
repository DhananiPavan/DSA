class Solution {
    public int search(int[] nums, int target) {
      return binary(nums,0,nums.length-1,target);  
    }
    int binary(int[] nums,int l,int r,int t){
        if(l>r){
            return -1;

        }
        int mid=l+(r-l)/2;
        if(nums[mid]==t) return mid;
        else if(nums[mid]<t) {
            return binary(nums,mid+1,r,t);

        }
        
       return     binary(nums,l,mid-1,t);
        
    }
}