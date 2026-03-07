class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true; // duplicate found
            }
            set.add(n);
        }
        return false; // all unique
        
    }
}
/*e*/