class Solution {
    public int smallestIndex(int[] nums) {
        


        for(int i =0;i<nums.length;i++){
            if(i==digits(nums[i])){
                return i;
            }
        }
        return -1;
    }
    public int digits(int val){
        int n=val;
        int sum=0;
        while(n!=0){
            
            sum+= n%10;
            n/=10;
        }
        return sum;
    }
}