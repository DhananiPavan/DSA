class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> ans = new ArrayList<>();
    //    int max=0;
    //    for(int x: nums){
    //     max=Math.max(x,max);
    //    } 
    //    int[] arr= new int[max+1];
    //    for(int x:nums){
    //     arr[x]=arr[x]+1;
    //     if(arr[x]>=2){
    //         ans.add(x);
    //     }
    //    }
    for(int i=0;i<nums.length;i++){
        //find index
        int index = Math.abs(nums[i]) - 1;
        if(nums[index]<0){
            ans.add(Math.abs(index+1));
        }
        else{
            nums[index]=-1*nums[index];
        }
    }
       
       return ans;
    }
}