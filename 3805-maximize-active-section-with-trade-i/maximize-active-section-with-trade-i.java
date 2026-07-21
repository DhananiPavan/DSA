class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
       int n= s.length();
       int i=0 , prev=-1,max=0,ones=0;
       while(i<n){
        if(s.charAt(i)=='1'){
         ones++;
         i++;
        }
        else{
            int cur=0;
            while(i<n && s.charAt(i)=='0'){
                cur++;
                i++;
            }
            if(prev>-1){
              max=Math.max(max,cur+prev);  
            }
            prev=cur;
        }

       }
       return ones+max; 
    }
}