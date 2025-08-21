class Solution {
    public int missingNumber(int[] nums) {
       int miss=0;
     
        for(int i=0;i<=nums.length;i++){
            miss=i ;
            boolean m=false;
            for(int j=0;j<nums.length;j++){
                if(miss==nums[j]){
                m=true;
                break;
                }
                
            }
            if(m!=true){
             return miss;
            }


        }
          return -1;
        
    }
    
    
}