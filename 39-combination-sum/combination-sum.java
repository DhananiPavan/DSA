class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        backTracking(0,candidates,target,ans,new ArrayList<>());
        return ans;

    }
   void backTracking(int ind,int[] arr,int target,List<List<Integer>> ans, List<Integer> temp){
        
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));

            }
            return;
        }

        if(arr[ind]<=target){
            temp.add(arr[ind]);
            backTracking(ind,arr,target-arr[ind],ans,temp);
            temp.remove(temp.size()-1);

        }
        backTracking(ind+1,arr,target,ans,temp);
    }
}