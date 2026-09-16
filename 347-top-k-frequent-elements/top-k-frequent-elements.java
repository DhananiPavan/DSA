// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//          HashMap<Integer, Integer> map = new HashMap<>();

//         // Count frequencies
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//         List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

//         // Sort by frequency (descending)
//         list.sort((a, b) -> b.getValue() - a.getValue());

//         // Store top k elements
//         int[] ans = new int[k];
//         for (int i = 0; i < k; i++) {
//             ans[i] = list.get(i).getKey();
//         }
//          return ans;
//     }
// }


import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count element frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Initialize buckets where index = frequency
        // Max frequency possible is nums.length
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        // Step 3: Iterate backwards from highest frequency bucket to collect top k elements
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}


// Yes, that's correct. ✅

// ```java
// list.sort((a, b) -> a.getValue() - b.getValue());
// ```

// This sorts the list in **ascending order** (smallest frequency first).

// ### Example

// Suppose the list contains:

// ```text
// (1,3)
// (2,1)
// (3,2)
// ```

// Using

// ```java
// list.sort((a, b) -> a.getValue() - b.getValue());
// ```

// Result:

// ```text
// (2,1)
// (3,2)
// (1,3)
// ```

// ---

// ### Descending Order

// ```java
// list.sort((a, b) -> b.getValue() - a.getValue());
// ```

// Result:

// ```text
// (1,3)
// (3,2)
// (2,1)
// ```

// ---

// ### A Better Practice

// Instead of subtracting values, use `Integer.compare()` because it avoids integer overflow.

// **Ascending:**

// ```java
// list.sort((a, b) -> Integer.compare(a.getValue(), b.getValue()));
// ```

// **Descending:**

// ```java
// list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
// ```

// Or, using the `Comparator` utility (very common in interviews):

// ```java
// // Ascending
// list.sort(Comparator.comparing(Map.Entry::getValue));
//desending
//list.sort(Comparator.comparing(Map.Entry::getValue).reversed());

// // Descending
// list.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed());
// ```

// For LeetCode, `a.getValue() - b.getValue()` works because the frequencies are small, but `Integer.compare()` is the safer and more professional approach.
