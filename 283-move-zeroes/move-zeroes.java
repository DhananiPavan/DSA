class Solution {
    public void moveZeroes(int[] a) {
        int i=0;
        for(int j=0;j<a.length;j++){
           
            if(a[j]!=0){

                a[i++]=a[j];
                
            }
        }
        while(i<a.length){
            a[i]=0;
            i++;
        }
         // if(a[j]!=0)
            //    {
            //     a[i]=a[j];
            //        if(i!=j)
            //          {
            //           a[j]=0;
            //          }
            //     i++;
            // }

       
        
    }
}