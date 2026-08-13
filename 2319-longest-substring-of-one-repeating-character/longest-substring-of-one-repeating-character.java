class Solution {

    class Node {
        int len;
        int leftMax;
        int rightMax;
        int max;
        char leftChar;
        char rightChar;

        Node(int len, int leftMax, int rightMax, int max,
             char leftChar, char rightChar) {

            this.len = len;
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.max = max;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String s, String queryCharacters,
                                   int[] queryIndices) {

        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];

            // Update character
            this.s[index] = queryCharacters.charAt(i);

            // Update segment tree
            update(1, 0, n - 1, index);

            // Root contains answer for entire string
            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(
                1,       // len
                1,       // leftMax
                1,       // rightMax
                1,       // max
                s[l],    // leftChar
                s[l]     // rightChar
            );
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int index) {

        if (l == r) {
            tree[node] = new Node(
                1,
                1,
                1,
                1,
                s[l],
                s[l]
            );
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    Node merge(Node left, Node right) {

        int len = left.len + right.len;

        int leftMax = left.leftMax;
        int rightMax = right.rightMax;

        int max = Math.max(left.max, right.max);

        // Same character at the boundary
        if (left.rightChar == right.leftChar) {

            // Repeating substring crosses the boundary
            max = Math.max(
                max,
                left.rightMax + right.leftMax
            );

            // Entire left segment is same character
            if (left.leftMax == left.len) {
                leftMax = left.len + right.leftMax;
            }

            // Entire right segment is same character
            if (right.rightMax == right.len) {
                rightMax = right.len + left.rightMax;
            }
        }

        return new Node(
            len,
            leftMax,
            rightMax,
            max,
            left.leftChar,
            right.rightChar
        );
    }
}