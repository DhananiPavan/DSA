class Solution {
    public int countSubstrings(String s) {
      int n= s.length();
      int count=0;
      for(int i=0;i<n;i++){
        count+=pal(s,i,i);
        count+=pal(s,i,i+1);
        //aaa
        
      }  
      return count;
    }
    public int pal(String s,int l,int r){
        int count=0;

        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r) ){
            count+=1;
            l--;
            r++;

        }
        return count;
    }
}
