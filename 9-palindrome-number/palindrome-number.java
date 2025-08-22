class Solution {
    public boolean isPalindrome(int x) {
        int n=x,a=0,r=0;
        while(n!=0){
            a=n%10;
            r=(r*10)+a;
            n=n/10;


        }
        if(x==r && r>=0){
           return true;

        }
        else{
           return false;
        }
        
    }
}