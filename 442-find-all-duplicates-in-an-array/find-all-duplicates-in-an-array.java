class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> ans = new ArrayList<>();
       int max=0;
       for(int x: nums){
        max=Math.max(x,max);
       } 
       int[] arr= new int[max+1];
       for(int x:nums){
        arr[x]=arr[x]+1;
        if(arr[x]>=2){
            ans.add(x);
        }
       }
       return ans;
    }
}