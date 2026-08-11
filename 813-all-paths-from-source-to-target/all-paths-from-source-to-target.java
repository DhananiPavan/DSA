class Solution {
     List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
     List<Integer> ls= new ArrayList<>();
     dfs(0,graph,ls);

      return ans;   
    }
    public void dfs(int node ,int[][] g,List<Integer> ls){
       

        ls.add(node);
        if(node == g.length - 1){
            ans.add(new ArrayList<>(ls));
            ls.remove(ls.size()-1);
            return;
        }
        for(int it :g[node]){
            dfs(it,g,ls);
        }
        ls.remove(ls.size()-1);
    }
}