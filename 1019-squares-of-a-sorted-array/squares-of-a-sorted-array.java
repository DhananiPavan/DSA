class Solution {
    public int[] sortedSquares(int[] nums) {
      //Two pointer
      int temp[]=new int[nums.length];
      int l=0;
      int r=nums.length-1;
      int i=r;
      while(l<=r){
        if(Math.abs(nums[l])<Math.abs(nums[r])){
            temp[i]=nums[r]*nums[r];
            r--;
        
        }
        else{
            temp[i]=nums[l]*nums[l];
            l++;

        }
        i--;
      }
      return temp;

    }
}