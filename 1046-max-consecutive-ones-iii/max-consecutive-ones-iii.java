class Solution {
    public int longestOnes(int[] arr, int k) {
          int start=0;
        int max=Integer.MIN_VALUE;
        int zero=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
           if(arr[i]==0){
               zero++;
               
           }   
           if(zero>k){
               if(arr[start]==0){
                   zero--;
               }
               start++;
               
           }
           max=Math.max(max,i-start+1);
        }
        return max;
        
    
        
    }
}