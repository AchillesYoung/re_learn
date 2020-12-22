package Lead2Offer.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack2Queue {

	public static class TwoStacks4Queue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;
		Integer target;
		public TwoStacks4Queue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {

			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
				 target = stackPop.pop();
				//再压回去
				while (!stackPop.empty()) {
					stackPush.push(stackPop.pop());
				}
			}
			return target;
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
				target = stackPop.peek();
				//再压回去
				while (!stackPop.empty()) {
					stackPush.push(stackPop.pop());
				}
			}
			return target;
		}

	}

	public static class TwoQueues4Stack {
		private Queue<Integer> data;
		private Queue<Integer> help;

		public TwoQueues4Stack() {
			data = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(int pushInt) {
			data.add(pushInt);
		}

		public int peek() {
			//先pop出来到另外一个队列，然后取最后一个，再pop
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			help.add(res);
			//swap是关键
			swap();
			return res;
		}

		public int pop() {
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size() > 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}

	}

	public static void main(String[] args) {
		TwoStacks4Queue queue =new TwoStacks4Queue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());


	}

}
