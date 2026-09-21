class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }
            
            // Generate a unique key based on character frequencies
            StringBuilder sb = new StringBuilder();
            for (int val : count) {
                sb.append('#').append(val);
            }
            String key = sb.toString();
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        
        return new ArrayList<>(map.values());
    }
}