class Solution {
    public int reverse(int x) {
        int n=x,r=0,a=0,c=0;
        
        while(n!=0)
        {
            a=n%10;
           
            n=n/10;
        if (r > Integer.MAX_VALUE/10 || (r == Integer.MAX_VALUE/10 && a > 7)) return 0;
        if (r < Integer.MIN_VALUE/10 || (r == Integer.MIN_VALUE/10 && a < -8)) return 0;
        r=r*10+a;

        }
        return r;
        
       

      
            
        
    }
  
}
