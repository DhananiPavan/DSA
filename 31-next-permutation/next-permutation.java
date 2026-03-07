class Solution {
    public void nextPermutation(int[] a) {
     int n=a.length;
     int ind=-1;
     for(int i=n-2;i>=0;i--){
        if(a[i]<a[i+1]){
            ind=i;
            break;
        }
     } 
    
     if(ind>=0){
        for(int i=n-1;i>ind;i--){
            if(a[ind]<a[i]){
             int temp=a[i];
             a[i] =a[ind];
             a[ind]=temp;
             break;
            }
        }

       
     } 
      reverse(a,ind+1,n-1);

  
        

       
    }
        public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
        
    
}