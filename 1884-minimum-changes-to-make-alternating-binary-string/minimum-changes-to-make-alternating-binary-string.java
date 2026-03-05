class Solution {
    public int minOperations(String s) {
       
       int c1=0;
       int c2=0;
       int i=0;
       while(i<s.length()){
        if((i & 1)==0){
            if(s.charAt(i)!='0')c1++;
            if(s.charAt(i)!='1')c2++;
        }
        else{
            if(s.charAt(i)!='0')c2++;
            if(s.charAt(i)!='1')c1++;

        }
        i++;
       }
      int count=Math.min(c1,c2);
       return count;
       
    }
}