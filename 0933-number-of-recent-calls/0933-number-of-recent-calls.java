import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        // Initialize an empty queue to store timestamps
        this.queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // 1. Add the current request timestamp
        queue.add(t);
        
        // 2. Remove any timestamps that are outside the 3000ms window
        // The window is [t - 3000, t]
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // 3. The remaining elements in the queue are all within the range
        return queue.size();
    }
}