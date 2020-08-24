package DataStructure.queue_stack;

import java.util.Stack;

/**
 * 时间复杂度O(1)
 */
public class StackMini {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> mini = new Stack<>();


    public StackMini() {

    }

    public void push(int x) {
        stack.push(x);
        if (mini.size() == 0) {
            mini.push(x);
        } else {
            if (mini.peek() >= x) {
                mini.push(x);
            }
        }
    }

    public void pop() {
        int top = stack.pop();
        if (mini.size() != 0) {
            if (top == mini.peek()) {
                mini.pop();
            }
        }
    }

    public int getMin(){
        return mini.peek();
    }

    public static void main(String[] args) {
        StackMini minStack = new StackMini();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}
