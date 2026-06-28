/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {

            ListNode kth = kth(temp, k);

            // Not enough nodes
            if (kth == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode next = kth.next;
            kth.next = null;

            // Reverse current group
            ListNode newHead = reverse(temp);

            // First group
            if (temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }

            // temp becomes tail after reverse
            prevLast = temp;

            temp = next;
        }

        return head;
    }

    // Find kth node
    private ListNode kth(ListNode head, int k) {

        while (head != null && --k > 0) {
            head = head.next;
        }

        return head;
    }

    // Reverse linked list
    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}