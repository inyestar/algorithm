package datastructure.queue;

import java.util.stream.IntStream;

public class Main {
	
	private static String MENU = "menu";

	public static void main(String[] args) {
		
		Queue<Dinner> queue = new Queue<>();
		
		IntStream.range(0, 5).forEach(x -> {
			queue.enqueue(new Dinner(MENU + x, x));
		});
		
		IntStream.range(0, 5).forEach(x -> {
			System.out.println(queue.dequeue());
		});
		
		queue.enqueue(new Dinner(MENU, 0));
		System.out.println(queue);
	}

	static class Dinner {
		
		String menu;
		int peopleWith;
		
		Dinner(String menu, int peopleWith) {
			this.menu = menu;
			this.peopleWith = peopleWith;
		}
		
		public String toString() {
			return new StringBuilder()
					.append(menu)
					.append("(")
					.append(peopleWith)
					.append(")")
					.toString();
		}
	}
}
