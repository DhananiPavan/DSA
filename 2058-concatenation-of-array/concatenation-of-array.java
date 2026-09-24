class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        int i =0;
        int j=0;
        while(i<ans.length){
            ans[i]=nums[j];
            i++;
            j++;
            if(j==nums.length)j=0;
        }
        return ans;
    }
}