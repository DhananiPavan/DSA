import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        List<Deque<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> numToGroup = new HashMap<>();

        // Group sorted elements
        for (int i = 0; i < n; i++) {
            if (groups.isEmpty() || sortedNums[i] - sortedNums[i - 1] > limit) {
                groups.add(new ArrayDeque<>());
            }
            int groupIdx = groups.size() - 1;
            groups.get(groupIdx).offer(sortedNums[i]);
            numToGroup.put(sortedNums[i], groupIdx);
        }

        // Reconstruct the answer array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int groupIdx = numToGroup.get(nums[i]);
            result[i] = groups.get(groupIdx).poll();
        }

        return result;
    }
}