class Solution {
    public int minMoves(int[] nums) {
      int max=Integer.MIN_VALUE;
      int ans=0;
      for(int x:nums){
        max=Math.max(max,x);
      }  
      for(int x:nums){
        ans+=Math.abs(max-x);
      }
      return ans;

      
    }
}