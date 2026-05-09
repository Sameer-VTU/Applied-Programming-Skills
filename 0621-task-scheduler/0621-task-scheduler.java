import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // 1. Count frequencies
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        // 2. Use Max-Heap to always pick the most frequent task
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> waitlist = new ArrayList<>();
            int cycle = n + 1; // Number of tasks we can do in one cooling period
            int taskCount = 0;

            // Try to perform up to 'cycle' number of tasks
            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    waitlist.add(maxHeap.poll() - 1);
                    taskCount++;
                }
            }

            // Put remaining tasks back into the heap
            for (int f : waitlist) {
                if (f > 0) maxHeap.add(f);
            }

            // If heap is empty, we only add the actual tasks performed
            // Otherwise, we add the full cycle time (including idle slots)
            time += (maxHeap.isEmpty()) ? taskCount : cycle;
        }

        return time;
    }
}