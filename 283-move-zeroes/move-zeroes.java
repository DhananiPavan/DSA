class Solution {
    public void moveZeroes(int[] a) {
        
        // int j=0,n=a.length;
        // for(int i=0;i<n;i++){
        //     if(a[i]==0){
        //    for( j=i;j<n-1;j++){
        //     a[j]=a[j+1];

        //    } 
        //    a[n-1]=0;
        //    n--;   
        //    i--;          
        //     }
        // }
        int i=0;
        for(int j=0;j<a.length;j++){
          if(a[j]!=0){
            a[i]=a[j];
            
           
            if(i!=j){
              a[j]=0;
            }
             i++;
           
          }

            
        }
       
        
    }
}