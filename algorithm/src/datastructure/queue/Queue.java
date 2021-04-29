package datastructure.queue;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Queue {
	
	private int[] queue;
	
	private int size;
	
	private int offset;

	public Queue() {
		size = 10;
		queue = new int[size];
		offset = 0;
	}
	
	public Queue(int size) {
		this.size = size;
		queue = new int[size];
		offset = 0;
	}
	
	/**
	 * data는 맨 마지막에 enqueue 됨
	 * @param data
	 * @throws QueueException
	 */
	public void enqueue(int data) throws QueueException {
		
		if(offset == size) {
			print();
			offset--;
			throw new QueueException("Queue fully occupied");
		}
		
		queue[offset++] = data;
	}
	
	/**
	 * 가장 첫 번째에 있는 data가 dequeue 됨
	 * @return
	 * @throws QueueException
	 */
	public int dequeue() throws QueueException {
		
		offset--;
		if(offset < 0) {
			print();
			offset = 0;
			throw new QueueException("Empty Queue");
		}
		
		int data = queue[0];
		for(int i=0; i<size; i++) {
			if(i < offset) {
				queue[i] = queue[i+1];
				continue;
			}
			queue[i] = 0;
		}
		return data;
	}
	
	public void print() {
		System.out.println(Arrays.toString(queue));
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		IntStream.range(0, 7).forEach(i -> {
			try {
				queue.enqueue(new Random().nextInt(100));
			} catch (QueueException e) {
				e.printStackTrace();
			}
		});
		queue.print();
		IntStream.range(0, 11).forEach(i -> {
			try {
				System.out.println(queue.dequeue());
			} catch (QueueException e) {
				e.printStackTrace();
			}
		});
	}
	
	public static class QueueException extends Exception {
		
		private static final long serialVersionUID = 1L;

		public QueueException(String msg) {
			super(msg);
		}
	}
}
