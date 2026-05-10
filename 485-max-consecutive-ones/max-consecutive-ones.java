class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        int count=0,max=0,n=a.length;
      
        for(int i=0;i<n;i++){

            if(a[i]!=0){
                count++;
            }
            else{
                count=0;
                
            }
            if(count>max){
                max=count;
            }
            

            
           

        }
        
        return max;
        
    }
}