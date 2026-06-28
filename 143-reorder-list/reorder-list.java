/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fst = head;
        ListNode prev = null;

        // find middle
        while (fst != null && fst.next != null) {
            prev = slow;
            slow = slow.next;
            fst = fst.next.next;
        }

        // split
        prev.next = null;

        // ADD THIS STEP → reverse second half
        ListNode curr = slow;
        ListNode prv = null;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prv;
            prv = curr;
            curr = nxt;
        }

        ListNode newhead2 = prv; // reversed second half
        ListNode newhead1 = head;

        // merge using your logic
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (newhead1 != null && newhead2 != null) {

            temp.next = newhead1;
            newhead1 = newhead1.next;
            temp = temp.next;

            temp.next = newhead2;
            newhead2 = newhead2.next;
            temp = temp.next;
        }

        if (newhead1 != null) {
            temp.next = newhead1;
            // temp = temp.next;
            // newhead1 = newhead1.next;
        }

        if (newhead2 != null) {
            temp.next = newhead2;
            // temp = temp.next;
            // newhead2 = newhead2.next;
        }
    }
}