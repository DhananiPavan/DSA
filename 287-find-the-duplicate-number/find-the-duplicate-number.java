class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}















// 1. Move slow(1), fast(2)
// 2. Find meeting point
// 3. Reset slow
// 4. Move both 1 step
// 5. Meeting = duplicate




// Starting from 0 or nums[0] both are fine
// 👉 Because:

// Index 0 eventually leads into the cycle
// Duplicate guarantees a loop
// ⚡ One-Line Memory

// 👉 “Start anywhere → you will reach the cycle”