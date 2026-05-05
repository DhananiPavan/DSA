class Solution {
    public void moveZeroes(int[] a) {
      int i=0;
      int n= a.length;
      for(int j=0;j<n;j++){
        if(a[j]!=0){
            a[i]=a[j];
            i++;

        }
      } 
      while(i<n){
        a[i]=0;
        i++;
      } 
    }
}