class Solution {
    static class Pair {
        TreeNode node;
        int num;
        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().num; // Base index to normalize values and avoid overflow
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                int normalizedIndex = cur.num - minIndex;

                if (i == 0) first = normalizedIndex;
                if (i == size - 1) last = normalizedIndex;

                if (cur.node.left != null) {
                    q.offer(new Pair(cur.node.left, normalizedIndex * 2 + 1));
                }
                if (cur.node.right != null) {
                    q.offer(new Pair(cur.node.right, normalizedIndex * 2 + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}