class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] temp=new int[nums1.length+nums2.length];
        int i=0;
        double ans=0;
        for(int a: nums1){
            temp[i++]=a;
        }
        for(int a: nums2){
            temp[i++]=a;

        }
        Arrays.sort(temp);
        if(temp.length%2!=0){
            int ind=((temp.length+1)/2)-1;
             ans=temp[ind];
        }
        else{
            int l=temp.length;
            int ind1=(l/2)-1;
            int ind2=l/2;
             ans =(temp[ind1]+temp[ind2])/2.0;
        }
        return ans;
    }
}