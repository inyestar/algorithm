package datastructure.stack;

import java.util.Arrays;

public class Stack<E> {

	private Object[] data;
	private int offset;
	private static final int MAXSIZE = 10;
	private static final int MINSIZE = 0;
	
	public Stack() {
		data = new Object[MAXSIZE];
	}
	
	@SuppressWarnings("unchecked")
	private E data(int index) {
		return (E) data[index];
	}
	
	private boolean isFull() {
		return offset == MAXSIZE;
	}
	
	private boolean isEmpty() {
		return offset < MINSIZE;
	}
	
	public void push(E e) {
		
		// check if stack is full
		if(isFull()) {
			throw new StackException("Stack is overflow");
		}
		
		data[offset++] = e;
	}
	
	public E pop() {
		--offset;
		if(isEmpty()) {
			throw new StackException("No data found in Stack");
		}
		E e = data(offset);
		data[offset] = null;
		return e;
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
}
