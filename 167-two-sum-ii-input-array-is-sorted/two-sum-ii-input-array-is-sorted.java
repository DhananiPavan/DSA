class Solution {
    public int[] twoSum(int[] a, int t) {
        int i=0;
        int j=a.length-1;
        while(i<j){
            int r=a[i]+a[j];
            if(r==t){
                return new int[]{i+1,j+1};
            }
            if(r<t){
                i++;

            }
            else{
                j--;
            }
        }
        return new int[]{-1};
    }
}