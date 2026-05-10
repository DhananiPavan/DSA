class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
     
      int l=0;
      int count=0;
      int n=nums.length;
      int pro=1;
       if(k <= 1) return 0;//most important edge  case
      for(int r=0;r<n;r++){
        pro*=nums[r];
        while(pro>=k){
            pro=pro/nums[l];
            l++;
        }
        count+=r-l+1;
      

      }  
      return count;
    }
}