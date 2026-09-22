class Solution {

    static class Node {
        int prod;
        int[] cnt; // cnt[r]: count of prefixes in this segment with product % k == r

        Node(int k) {
            cnt = new int[k];
        }
    }

    private Node[] tree;
    private int K;

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node res = new Node(K);
        res.prod = (left.prod * right.prod) % K;

        // Copy prefixes from the left child
        for (int r = 0; r < K; r++) {
            res.cnt[r] = left.cnt[r];
        }

        // Add prefixes extending into the right child
        for (int r = 0; r < K; r++) {
            if (right.cnt[r] > 0) {
                int newRem = (left.prod * r) % K;
                res.cnt[newRem] += right.cnt[r];
            }
        }

        return res;
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node] = new Node(K);
            int rem = nums[l] % K;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = l + (r - l) / 2;
        build(2 * node, l, mid, nums);
        build(2 * node + 1, mid + 1, r, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = new Node(K);
            int rem = val % K;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;
        Node leftRes = null;
        Node rightRes = null;

        if (ql <= mid) {
            leftRes = query(2 * node, l, mid, ql, qr);
        }
        if (qr > mid) {
            rightRes = query(2 * node + 1, mid + 1, r, ql, qr);
        }

        return merge(leftRes, rightRes);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        this.K = k;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // 1. Update nums[index] = value
            update(1, 0, n - 1, index, value);

            // 2. Query range [start, n - 1]
            Node qNode = query(1, 0, n - 1, start, n - 1);

            // 3. Store result for remainder x
            result[i] = qNode.cnt[x];
        }

        return result;
    }
}