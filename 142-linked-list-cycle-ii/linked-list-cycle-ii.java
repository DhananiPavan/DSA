/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
           if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {   // cycle detected
                break;
            }
        }

        // No cycle found
        if (fast == null || fast.next == null) {
            return null;
        }

        // Phase 2: Find the cycle start
        slow = head;  // move slow to start
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; 

        
    }
}