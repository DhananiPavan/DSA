class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        int r=m.length;
        int c=m[0].length;
        int l=0,t=0,b=r-1,rt=c-1;
        List<Integer> l1 = new ArrayList<>();
         while(t<=b&&l<=rt)
        {

         for(int i=l;i<=rt;i++){
            l1.add(m[t][i]);

         }
         t++;
         for(int i=t;i<=b;i++){
            l1.add(m[i][rt]);

         }
         rt--;
         if(t<=b){
            for(int i=rt;i>=l;i--){
            l1.add(m[b][i]);

         }
         b--;

         }

         if(l<=rt){
            for(int i=b;i>=t;i--){
            l1.add(m[i][l]);

         }
         l++;

         }


         }
         return l1;
        


        
    }
}