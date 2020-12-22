package Lead2Offer.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackMin {
    Deque<Integer> stack;
    Deque<Integer> mini;

    public StackMin() {
        stack = new LinkedList<Integer>();
        mini = new LinkedList<Integer>();
        mini.push(Integer.MAX_VALUE);
    }


    public void push(int value){
        stack.push(value);
        /**
         * �����ȸ�mini.push(Integer.MAX_VALUE);
         */
//        if(mini.isEmpty()){
//            mini.push(value);
//        }
//        if(value < mini.peek()){
//            mini.push(value);
//        }else {
//            mini.push(mini.peek());
//        }
        /**
         * �����Ƕ��Ż�Ϊ
         */
        mini.push(Math.min(value,mini.peek()));
    }
    public int getMin(){
        return mini.peek();
    }
    public void pop(){
        mini.pop();
        stack.pop();
    }
    public int top(){
        return stack.peek();
    }

}
