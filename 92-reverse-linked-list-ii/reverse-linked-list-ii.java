class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        // reach node before left
        for (int i = 1; i < left; i++) {
            temp = temp.next;
        }

        ListNode prev = temp;
        ListNode leftNode = temp.next;

        // move to actual right node
        temp = leftNode;

        for (int i = left; i < right; i++) {
            temp = temp.next;
        }

        ListNode rightNode = temp.next;

        // cut
        temp.next = null;

        // reverse and attach
        prev.next = reverse(leftNode, rightNode);

        return dummy.next;
    }

    public ListNode reverse(ListNode head, ListNode right) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {

            ListNode next = cur.next;

            cur.next = prev;

            prev = cur;

            cur = next;
        }

        // original head becomes tail
        head.next = right;

        return prev;
    }
}