class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
     return calcount(nums,k)-calcount(nums,k-1);   
        
    }
    private int  calcount(int[] nums,int k){
     int n=nums.length;
     int l=0;
     int count=0;
      Map<Integer, Integer> mpp = new HashMap<>();
      for(int r=0;r<n;r++){
        mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
        while(mpp.size()>k){
            mpp.put(nums[l],mpp.get(nums[l])-1);
            if(mpp.get(nums[l])==0){
                mpp.remove(nums[l]);
            }
            l++;

        }
        count+=r-l+1;
      }
      return count;
     
    }
}