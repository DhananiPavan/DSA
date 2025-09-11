class Solution {
    public int findPeakElement(int[] nums) {
        
    int n=nums.length;
    int l=0;
    int h=n-1;
    while(l<=h){
        int m=(l+h)/2;
        if(n==1){
            return 0;
        }
      
        if((m==0 ||nums[m]>nums[m-1]) && (m==n-1||nums[m]>nums[m+1]))
        {
            return m;
        }
        if(m>0 && nums[m]<nums[m-1] ){
            h=m-1;
        }
        else{
            l=m+1;
        }
       
    }
    return -1;
        

    }
}