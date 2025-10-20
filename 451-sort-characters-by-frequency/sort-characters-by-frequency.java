class Solution {
    public String frequencySort(String s) {
        
        // Step 1: Count frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters by frequency
        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> map.get(b) - map.get(a));

        // Step 3: Build the result
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int freq = map.get(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
          return sb.toString();
    }
}