class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return pow( x, n, 1);
    }
    public double pow(double x, int n,double ans){
        if(n==0){
            return ans;
        }
        if(n%2!=0){
            ans=ans*x;
        }
        return pow(x*x,n/2,ans);
    }
}