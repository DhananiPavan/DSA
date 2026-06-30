class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // Step 1: Reverse the linked list to process from right to left
        ListNode list = reverseList(head);
        
        // Count total nodes to initialize our array
        int count = 0;
        ListNode temp = list;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        int[] result = new int[count];
        Stack<Integer> st = new Stack<>();
        
        // Step 2: Traverse the reversed list and fill the array from back to front
        int index = count - 1;
        while (list != null) {
            // Maintain a strictly decreasing stack from top to bottom
            while (!st.isEmpty() && st.peek() <= list.val) {
                st.pop();
            }
            
            // If the stack is empty, there is no greater element to the right
            if (st.isEmpty()) {
                result[index] = 0;
            } else {
                result[index] = st.peek();
            }
            
            // Push the current value onto the stack for upcoming elements
            st.push(list.val);
            
            list = list.next;
            index--;
        }
        
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}