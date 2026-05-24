class Solution {
    public int mySqrt(int x) {
        if(x<2){
            return x;
        }
       long l=1;
       long r=x/2;
       while(l<=r){
        long mid=l+(r-l)/2;
        long value =mid*mid;
        if(value==x){
           return (int)mid;
        }
        else if(value>x){
            r=mid-1;

        }
        else{
            l=mid+1;
        }
       }
       return (int)r;
        
    }
}