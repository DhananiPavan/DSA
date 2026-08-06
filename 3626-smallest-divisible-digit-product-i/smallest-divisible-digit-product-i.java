class Solution {
    public int smallestNumber(int n, int t) {
      
     for(int i=n;i<=100;i++){
       int pro=pro(i);
       if(pro%t==0){
        return i;
       }
     } 
      return 0;
       
        
    }
    public int pro(int n){
      int results=1;
      while(n!=0){
        int r=n%10;
        results*=r;
        n=n/10;
      }
      return results;
    }
}