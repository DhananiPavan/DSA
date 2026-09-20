class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        int i=1;
        for(Character c:s.toCharArray()){
          sum +=i*(Math.abs((c-'a')-26));
          i++;
        }
        return sum;
    }
}