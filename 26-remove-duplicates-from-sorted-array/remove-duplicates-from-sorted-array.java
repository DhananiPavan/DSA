class Solution {
    public int removeDuplicates(int[] a) {
       int i=0;
       for(int j=1;j<a.length;j++){
        if(a[i]!=a[j]){
           a[i+1]=a[j];
           i++;

           

            
          
         

        }
        

       }
       return (i+1);
    
        
    }
}