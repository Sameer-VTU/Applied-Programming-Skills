class MyCircularDeque {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        data = new int[k];
        capacity = k;
        head = 0;
        tail = 0;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        // Move head backward and wrap around
        head = (head - 1 + capacity) % capacity;
        data[head] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        // Place value at current tail, then move tail forward
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : data[head];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        // Rear is at (tail - 1)
        return data[(tail - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}