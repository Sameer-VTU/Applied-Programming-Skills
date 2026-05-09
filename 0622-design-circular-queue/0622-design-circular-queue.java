class MyCircularQueue {
    private int[] queue;
    private int head;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.head = 0;
        this.count = 0;
        this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        // The rear index is calculated based on head and count
        int tail = (head + count) % capacity;
        queue[tail] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        // Move head forward circularly
        head = (head + 1) % capacity;
        count--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        // Rear is the last element added
        int tail = (head + count - 1) % capacity;
        return queue[tail];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}