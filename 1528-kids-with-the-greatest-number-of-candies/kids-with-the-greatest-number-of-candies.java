class Solution {
    public List<Boolean> kidsWithCandies(int[] c, int e) {
        int max=Integer.MIN_VALUE;
        for(int x: c){
            max=Math.max(x,max);
        }
        List<Boolean> ans= new ArrayList<>();
        for(int i =0;i<c.length;i++){
            if(max<=e+c[i]){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}