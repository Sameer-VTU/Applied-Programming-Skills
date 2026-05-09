import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean exploded = false;
            
            // Only potential collision: stack top moves right (+) and current moves left (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                    stack.pop(); // Top asteroid explodes, keep checking current ast
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    stack.pop(); // Both explode
                }
                exploded = true; // Current ast exploded or both exploded
                break;
            }
            
            if (!exploded) {
                stack.push(ast);
            }
        }

        // Convert stack to int array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}