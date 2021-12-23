package datastructure.stack;

import java.util.stream.IntStream;

public class Main {
	
	private static final String TITLE = "title";

	public static void main(String[] args) {
		Stack<Book> stack = new Stack<>();
		IntStream.range(0, 5)
			.forEach(x -> {
				stack.push(new Book(TITLE + x));
			});
		System.out.println(stack);
		
		IntStream.range(0, 5)
			.forEach(x -> {
				System.out.println(stack.pop());
			});
		stack.push(new Book("test"));
		System.out.println(stack);
	}
	
	static class Book {
		String title;
		
		Book(String title) {
			this.title = title;
		}
		
		public String toString() {
			return title;
		}
	}
}
