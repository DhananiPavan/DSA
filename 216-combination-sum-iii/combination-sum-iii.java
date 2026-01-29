class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(1,k,n,ans,new ArrayList<>());
        return ans;
        
    }
   void  backtracking(int ind,int num,int target,List<List<Integer>> ans,List<Integer> ds){
        if(num==0){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return ;
        }
        for (int i = ind; i <= 9; i++) {
            if (i > target) break;

            ds.add(i);
            backtracking(i + 1, num - 1, target - i, ans, ds);
            ds.remove(ds.size() - 1);
        }
         
                 

            
    }
}