class Solution {
    public int[] twoSum(int[] n, int target) {
        int l=0;
        int r=n.length-1;
        while(l<r){
           int sum =n[l]+n[r];
            if(sum==target){
                return new int[]{l+1,r+1};
            }
            if(sum > target){
                r--;

            }
            else{
                l++;
            }
        }
        return new int[]{-1};
    }
}