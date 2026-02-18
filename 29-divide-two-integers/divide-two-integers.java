// class Solution {
//     public int divide(int dividend, int divisor) {
//         if(dividend==divisor)return 1;
//         boolean si=true;
//         if((dividend<0 && divisor >0) || (dividend>0 && divisor <0)) si=false;
//        long b=Math.abs(dividend);
//        long s=Math.abs(divisor);
//       long ans=0;  
        
//         while(b>=s){
//             int count =0;
//             while(b>=(s<<(count+1))) count++;
//             ans +=(1<<count);
//             b=b-(s*(1<<count));
            
//         }
//         if(ans==(1<<31) && si){
//             ans=Integer.MAX_VALUE;
//         }
//         if(ans==(1<<31)&&!si){
//             ans=Integer.MIN_VALUE;
//         }

//         return si?(int)ans:(int)-ans;
        
//     }
// }


class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean positive = (dividend < 0) == (divisor < 0);

        long b = Math.abs((long) dividend);
        long s = Math.abs((long) divisor);

        long ans = 0;

        while (b >= s) {
            int count = 0;

            while (b >= (s << (count + 1))) {
                count++;
            }

            ans += (1L << count);
            b -= (s << count);
        }

        return positive ? (int) ans : (int) -ans;
    }
}
