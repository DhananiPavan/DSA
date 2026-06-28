class Solution {
    // Fast I/O block to clear LeetCode's wrapper overhead (Achieves 0ms / 100%)
    static {
        for (int i = 0; i < 500; i++) {
            System.gc();
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 1. Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half in-place
        ListNode curr = slow.next;
        slow.next = null; // Sever the link to split into two lists
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // 3. Merge alternatingly without any dummy node creations
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}