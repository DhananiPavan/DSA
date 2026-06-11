import java.util.Stack;

class MyQueue {

    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    // O(n)
    public void push(int x) {
        insertAtBottom(x);
    }

    private void insertAtBottom(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        int top = stack.pop();
        insertAtBottom(x);
        stack.push(top);
    }

    // O(1)
    public int pop() {
        return stack.pop();
    }

    // O(1)
    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */