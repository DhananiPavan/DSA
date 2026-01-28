class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(nums);
        backtracking(0,nums,ans,new ArrayList<>());
        return ans;
      

    }
  void  backtracking(int ind, int[] arr,List<List<Integer>> ans,List<Integer> temp){
      
      ans.add(new ArrayList<>(temp));
      for(int i =ind;i<arr.length;i++){
        if(i>ind && arr[i]==arr[i-1]) continue;
        
        
        temp.add(arr[i]);
        backtracking(i+1,arr,ans,temp);
        temp.remove(temp.size()-1);
        
     
      }
      return;
    }

}