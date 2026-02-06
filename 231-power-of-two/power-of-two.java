class Solution {
    public boolean isPowerOfTwo(int n) {
       
     return (n >0 && (n &(n-1))==0);
     //8+7 1000+0111=0000 true ;10=1010 9=1001 =1000 false;
    }
}