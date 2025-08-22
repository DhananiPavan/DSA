class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(gen(i));
        }
        return ans;
    }
    List<Integer> gen(int r){
        List<Integer> temp=new ArrayList();
       int ans=1;
        temp.add(ans);
        for(int i=1;i<r;i++){
            ans=ans*(r-i);
            ans=ans/i;
            temp.add(ans);
        }
        return temp;
    }
}