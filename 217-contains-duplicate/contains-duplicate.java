class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        boolean b=false;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                b=true;
            }
           
        }
        return b;
    }
}
/* Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true; // duplicate found
            }
            set.add(n);
        }
        return false; // all unique*/