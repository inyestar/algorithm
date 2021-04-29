package datastructure.stack;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Stack {

	private int[] stack;
	
	private int offset;
	
	private int size;
	
	public Stack() {
		size = 10;
		stack = new int[size];
		offset = 0;
	}
	
	public Stack(int size) {
		this.size = size;
		stack = new int[this.size];
		offset = 0;
	}
	
	/**
	 * data는 맨 마지막에 push 됨
	 * @param data
	 * @throws StackException
	 */
	public void push(int data) throws StackException {
		if(offset == size) {
			print();
			offset--;
			throw new StackException("Stack Overflow");
		}
		stack[offset++] = data;
	}
	
	/**
	 * 가장 마지막에 추가된 data가 pop됨
	 * @return
	 * @throws StackException
	 */
	public int pop() throws StackException {
		
		if(offset < 0) {
			print();
			offset = 0;
			throw new StackException("Empty Stack");
		}
		
		int data = stack[offset == size ? --offset : offset];
		stack[offset--] = 0;
		return data;
	}

	public void print() {
		System.out.println(Arrays.toString(stack));
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		IntStream.range(0, 10).forEach(i -> {
			try {
				stack.push(new Random().nextInt(100));
			} catch (StackException e) {
				e.printStackTrace();
			}
		});
		stack.print();
		IntStream.range(0, 11).forEach(i -> {
			try {
				System.out.println(stack.pop());
				stack.print();
			} catch (StackException e) {
				e.printStackTrace();
			}
		});
	}
	
	private static class StackException extends Exception {
		
		private static final long serialVersionUID = 1L;

		StackException(String msg) {
			super(msg);
		}
	}
}
