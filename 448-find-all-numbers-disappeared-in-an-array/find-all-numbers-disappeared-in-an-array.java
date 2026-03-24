class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     List<Integer> ans= new ArrayList<>();

     for(int i=0;i<nums.length;i++){         
       int index=Math.abs(nums[i])-1;
        if(nums[index]>0){
            nums[index]=-nums[index];
        }
     }
     for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
            ans.add(i+1);
        }
     }


     return ans;
    }
}
// 1. Take abs value
// 2. Go to index (val-1)
// 3. Mark negative
// 4. Positive index ⇒ missing


// Procedure (Quick Notes)
// ✅ Step 1: Traverse array
// Take each element val = abs(nums[i])
// ✅ Step 2: Map value to index
// Convert number → index
// 👉 index = val - 1
// ✅ Step 3: Mark as visited
// If nums[index] > 0
// 👉 Make it negative
// 👉 nums[index] = -nums[index]
// ✅ Step 4: Find missing numbers
// Traverse again
// If nums[i] > 0
// 👉 Missing number = i + 1