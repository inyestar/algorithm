package datastructure.queue;

import java.util.Arrays;

public class Queue<E> {

	private Object[] data = null;
	private int head;
	private int tail;
	private int size;
	private static int DEFAULTSIZE = 10;
	
	public Queue() {
		this(DEFAULTSIZE);
		size = DEFAULTSIZE;
	}
	
	public Queue(int size) {
		this.size = size;
		data = new Object[size];
	}
	
	@SuppressWarnings("unchecked")
	private E data(int index) {
		return (E) data[index];
	}
	
	private boolean needResize() {
		return tail == size;
	}
	
	// XXX: 최대 증가 크기를 어떻게 정해야 하지
	@SuppressWarnings("unchecked")
	private void resize() {
		int oldSize = size;
		size = tail + 1;
		E[] copy = (E[]) new Object[size];
		System.arraycopy(data, 0, copy, 0, oldSize);
		data = copy;
	}
	
	private boolean isEmpty() {
		return head == tail;
	}
	
	public void enqueue(E e) {
		// check if array is required to resize
		if(needResize()) {
			resize();
		}

		if(isEmpty()) {
			head = 0;
			tail = 0;
		}
		
		data[tail++] = e;
	}
	
	public E dequeue() {
		// check if data exists
		if(isEmpty()) {
			throw new QueueException("No data found in Queue");
		}
		
		E e = data(head);
		data[head++] = null;
		
		return e;
	}
	
	public E peek() {
		return data(head);
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
}
