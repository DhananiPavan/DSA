class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int l=i+1;
            int r=nums.length-1;
            while(l<r){
               int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    l=l+1;
                    while( l<r && nums[l]==nums[l-1])l++;
                    

                   
                } 
                if(sum>0){
                    r--;
                }
                if(sum<0){
                    l++;
                }
                
               
               
                
            }
        }
        return ans;
    }
}