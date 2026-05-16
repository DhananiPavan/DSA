class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       Map<Integer,Integer>mpp =new HashMap<>();
       mpp.put(0,1);
       int prefix=0;
       int count=0;
       for(int i=0;i<nums.length;i++){
        prefix+=nums[i];
        int rem=prefix%k;
        if(rem<0) rem+=k;//check for -ve if -4 come -4+5=1 the -4 = 1 remainder
        if(mpp.containsKey(rem)){
           count+=mpp.get(rem); 
           
        }
        
            mpp.put(rem,mpp.getOrDefault(rem,0)+1);
        

       }
       return count; 
    }
}