import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        // We'll modify the array in-place to save space
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // While stack is not empty and current price is <= price at stack top
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // Apply the discount to the item at the popped index
                int indexToDiscount = stack.pop();
                prices[indexToDiscount] -= prices[i];
            }
            // Push current index onto stack
            stack.push(i);
        }
        
        return prices;
    }
}