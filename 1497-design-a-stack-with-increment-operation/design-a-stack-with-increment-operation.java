class CustomStack {
    private int[] stack;
    private int [] incre;
    private int top;
    private int maxsize;

    public CustomStack(int maxSize) {
        this.stack=new int[maxSize];
        this.incre =new int[maxSize];
        this.maxsize=maxSize;
        this.top=0;
    }
    
    public void push(int x) {
        if(top<maxsize){
            stack[top]=x;
            incre[top]=0;
            top++;
        }
        
    }
    
    public int pop() {
        
        if(top==0){
            return -1;
        }
        top--;
        int value= stack[top]+incre[top];
        if(top>0)incre[top-1]+=incre[top];
        // incre[top]=0;
        return value;
        
    }
    
    public void increment(int k, int val) {
        int idx=Math.min(top,k)-1;
        if(idx>=0){
            incre[idx]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */