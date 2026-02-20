class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;//if xor on same pair it return 0 and 
              //0^single number it return single number

        for(int  i=0;i<nums.length;i++){
            xor=xor ^ nums[i];
        }
        return xor;
        
    }
}