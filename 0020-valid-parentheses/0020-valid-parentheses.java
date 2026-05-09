import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push the corresponding closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, check if it matches the top of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // If stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}