class Solution {
    public int firstUniqChar(String s) {
        int index=-1,c=0;
        for(int i=0;i<s.length();i++)
        {  c=0;
            for(int j=0;j<s.length();j++){
                if(i!=j&&s.charAt(i)==s.charAt(j)){
                c++;
                break;

                }
            }
            if(c==0){
            return i;
            }
           
        }
        return -1;
        
    }
}