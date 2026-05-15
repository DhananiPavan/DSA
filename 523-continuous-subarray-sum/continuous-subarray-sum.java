class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       Map<Integer,Integer> mpp=new HashMap<>();
       mpp.put(0,-1);
       int prefix=0;
       for(int i=0;i<nums.length;i++){
           prefix+=nums[i];
           int rem=prefix%k;
           if(mpp.containsKey(rem)){
            if(i-mpp.get(rem)>=2){
                return true;
            }
            
           }
           else{
            mpp.put(rem,i);
           }
       }    
       return false;
    }
}