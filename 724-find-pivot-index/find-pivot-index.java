class Solution {
    public int pivotIndex(int[] nums) {
    int l=0;int r=0;
    int sum=0;
    for(int x:nums){
        sum+=x;
    }
    for(int i=0;i<nums.length;i++){

     r=sum-nums[i]-l;
      if(l==r){
        return i;
      }
      l+=nums[i];
    }


      return -1;  
    }
}