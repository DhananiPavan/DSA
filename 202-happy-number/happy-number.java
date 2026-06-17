class Solution {
    public boolean isHappy(int n) {
      
      if(n<10){
        if(n==1||n==7){
            return true;
        }
         return false;
       }
        
      int x=n;int sum=0;
      while(x!=0){
        int b=x%10;
        sum+= (int) Math.pow(b,2);
        x=x/10;
      }  
      return isHappy(sum);
    }
}