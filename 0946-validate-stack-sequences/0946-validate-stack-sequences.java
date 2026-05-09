import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // Pointer for the popped array

        for (int x : pushed) {
            stack.push(x); // Greedily push the next element
            
            // While stack is not empty and top matches the current 'popped' element
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++; // Move to the next element we want to pop
            }
        }

        // If all elements were successfully popped, stack will be empty
        return stack.isEmpty();
    }
}