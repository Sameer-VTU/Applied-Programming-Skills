class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Using Deque for Stack is better practice in Java

        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            
            // While the current temperature is warmer than the temperature at the top index
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // Distance between days
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }

        return answer;
    }
}