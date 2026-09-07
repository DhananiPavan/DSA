class Solution {
    public int trailingZeroes(int n) {

     int ans=0;
     int pro=5;
     while((n/pro)!=0){
        ans=ans+n/pro;
        pro=pro*5;
     }
return ans;

    }
}