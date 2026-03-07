class Solution {
    public void rotate(int[] nums, int k) {
      k= k % nums.length;
      int  n=nums.length;
    
     reverse(nums,0,n-1);
     reverse(nums,0,k-1);
     reverse(nums,k,n-1);


        
    }
    private void reverse(int[]a,int s,int l){
        while(s<l){
            int temp=a[s];
            a[s]=a[l];
            a[l]=temp;
            l--;
            s++;

        }
    }
}