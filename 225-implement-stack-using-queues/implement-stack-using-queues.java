class MyStack {
    Queue<Integer> q;

    public MyStack() {
        // Using ArrayDeque is often slightly faster than LinkedList in Java
        q = new ArrayDeque<>(); 
    }
    
    public void push(int x) {
        q.add(x);
        int size = q.size();
        // Rotate the queue so the newly added element is at the front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}