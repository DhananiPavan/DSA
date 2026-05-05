class Solution {
    public void sortColors(int[] nums) {
        
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(mid<=end){
            if(mid<=end && nums[mid]==0){
                swap(nums,start,mid);
                start++;
                mid++;
            }
           else if(mid<= end && nums[mid]==2){
                 swap(nums,mid,end);
                 end--;
            }
            if(mid<=end && nums[mid]==1){

             mid++;
            }
        }
    }
    void swap(int []nums,int i,int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
    }
}