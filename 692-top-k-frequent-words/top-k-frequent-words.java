class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> mp = new HashMap<>();
        for (String w : words) {
            mp.put(w,mp.getOrDefault(w, 0) + 1);
        }
        List<String>[] ls = new List[words.length + 1];
        for (String key : mp.keySet()) {
            int f = mp.get(key);
            if (ls[f] == null) {
                ls[f] = new ArrayList<>();

            }
            ls[f].add(key);

        }
        for(int i=1;i<words.length;i++){
            if(ls[i]==null)continue;
            Collections.sort(ls[i]);
        }
        List<String> ans= new ArrayList<>();
         for(int i=ls.length-1;i>=0 && ans.size()<k;i--){
            if(ls[i]!=null){
                for(String w:ls[i]){
                ans.add(w);
                 if(ans.size()==k){
                break;
            }
            }
           
            }
         }
         return ans;
    }
}