class Solution {
    public int mySqrt(int x) {
       long l=1;
       long r=x;
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