class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      List<Integer> l=new ArrayList();
     int l1=0,l2=0;
     int e1=m-1,e2=n-1;
     while(l1<=e1 && l2 <=e2){
        if(nums1[l1]<=nums2[l2] ){
            l.add(nums1[l1]);
            l1++;

        }
        else{
            l.add(nums2[l2]);
            l2++;

        }
     }
     while(l1<=e1){
            l.add(nums1[l1]);
            l1++;
     }
      while(l2<=e2){
            l.add(nums2[l2]);
            l2++;
     }
     int i1=0;
     for(int i:l){
        nums1[i1]=i;
        i1++;
     }
     

    
       
    }
}