import java.util.Stack;

class StockSpanner {
    // Stack stores int array: [price, span]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // While stack is not empty and the previous price is <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the span of the previous price to the current span
            span += stack.pop()[1];
        }
        
        // Push the current price and its total span
        stack.push(new int[]{price, span});
        
        return span;
    }
}