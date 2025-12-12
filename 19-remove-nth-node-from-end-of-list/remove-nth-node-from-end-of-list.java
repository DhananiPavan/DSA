class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fst = head;
        ListNode slow = head;
        int i = 0;
        // Move fast n steps ahead
        while ( i < n) {
            fst = fst.next;
            i++;
        }

        // If fst is null, delete head
        if (fst == null) {
            return head.next;
        }

        // Move both pointers until fst reaches last node
        while (fst.next != null) {
            fst = fst.next;
            slow = slow.next;
        }

        // Delete target node
        slow.next = slow.next.next;

        return head;
    }
}
