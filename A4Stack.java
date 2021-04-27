


public class A4Stack<T> implements Stack<T> {
	
	private static final int DEFAULT_CAPACITY = 5;
	public T[] data;
	private int top;

	public A4Stack() {
		data = (T[]) new Object[DEFAULT_CAPACITY];
		top = 0;
	}
	
	public A4Stack(int size) {
		data = (T[]) new Object[size];
		top = 0;
	}



	/*
	 * Purpose: Insert an item onto the top of the stack
	 * Parameters: (int) - the item to insert
	 * Returns: Nothing
	 * Throws: FullStackException if array is full
	 */
	public void push(T v) throws FullStackException{
		// TODO: implement this
		if (isFull() == true){
			throw new FullStackException("The array is FULL");
		}
//		int length = data.length;
//		if (top >= length){
//			T[] Nd = (T[]) new Object[top*2];
//			for (int i = 0; i <data.length ; i++) {
//				Nd[i] = data[i];
//			}
//			data = Nd;
//		}
		else {
			data[top] = v;
			top++;
		}
	}



	/*
	 * Purpose: Removes and returns the top item from the stack
	 * Parameters: None
	 * Returns: (int) - the data value of the element removed
	 * Throws: EmptyStackException if array is empty
	 */
	public T pop() throws EmptyStackException {
		// TODO: implement this
		if (isEmpty()==true){
			throw new EmptyStackException("The array is Empty");
		}
		T deleting;
		top--;
		deleting = data[top];
		data[top] = null;
		return deleting; // so it compiles
	}



	/*
	 * Purpose: Removes all elements from the stack
	 * Parameters: None
	 * Returns: Nothing
	 */
	public void popAll() {
		// TODO: implement this

			int i = top-1;
			while (i>=0){
				pop();
				i--;
			}
	}

	/*
	 * Purpose: Determines whether the stack is empty
	 * Parameters: None
	 * Returns: (boolean) - true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		// TODO: implement this	
		if (top ==0) {
			return true;
		}
		return false; // so it compiles
	}

	/*
	 * Purpose: Determines whether the stack is full
	 * Parameters: None
	 * Returns: (boolean) - true if the stack is full, false otherwise
	 */
	public boolean isFull() {
		// TODO: implement this
		if (top >= data.length) {
			return true;
		}
		return false; // so it compiles
	}

	/*
	 * Purpose: Accesses the top item on the stack
	 * Parameters: None
	 * Returns: (int) - the data value of the top element
	 * Throws: EmptyStackException if array is empty
	 */
	public T top() throws EmptyStackException {
		// TODO: implement this
		if (isEmpty()==true || top < 0){
			throw new EmptyStackException("Array is EMPTY");
		}
		return data[top - 1];
	}
}