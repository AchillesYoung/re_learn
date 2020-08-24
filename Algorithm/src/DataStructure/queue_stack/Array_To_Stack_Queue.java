package DataStructure.queue_stack;

public class Array_To_Stack_Queue {

	public static class ArrayStack {
		private Integer[] arr;
		private Integer index;//这里的size指的是堆栈指针

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			//size也是计数指针
			index = 0;
		}

		public Integer peek() {
			if (index == 0) {
				return null;
			}
			//peek时候size没变
			return arr[index - 1];
		}

		public void push(int obj) {
			if (index == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			//先传值再++
			arr[index++] = obj;
		}

		public Integer pop() {
			if (index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			//先--再给值，但是不删掉
			return arr[--index];
		}
	}

	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			//队列需要开头结尾两个指针
			size = 0;
			first = 0;
			last = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			//peek的话就是第一个
			return arr[first];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			//push就是添加，需要size++
			//last复制，假如last是最后一个，那么=0
			size++;
			arr[last] = obj;
			last = last == arr.length - 1 ? 0 : last + 1;
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			//弹出，如果。
			size--;
			int tmp = first;
			first = first == arr.length - 1 ? 0 : first + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {

	}

}
