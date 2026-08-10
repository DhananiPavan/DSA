class Solution {
    class Node {
        String name;
        int val;

        Node(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Node> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        q.offer(new Node(beginWord, 1));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            char[] ch = cur.name.toCharArray();
            int len = cur.name.length();
            for (int i = 0; i < len; i++) {
                char original = ch[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    if (set.contains(String.valueOf(ch))) {

                        if (String.valueOf(ch).equals(endWord)) {
                            return cur.val + 1;
                        }
                        q.offer(new Node(String.valueOf(ch), cur.val + 1));
                        set.remove(String.valueOf(ch));
                    }

                }

                ch[i] = original;
            }

        }
        return 0;

    }
}