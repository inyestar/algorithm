package datastructure.list;

import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Chicken> linkedList = new LinkedList<>();
		IntStream.range(0, 10).forEach(x -> {
			linkedList.add(new Chicken("kokio" + x, x * 1000));
		});
		System.out.println(linkedList);
		System.out.println(linkedList.get(9));
		linkedList.remove(9);
		System.out.println(linkedList);
		
		linkedList.remove(new Chicken("kokio7", 7000));
		System.out.println(linkedList);
	}

	static class Chicken {
		String name;
		int price;
		
		Chicken(String name, int price) {
			this.name = name;
			this.price = price;
		}
		
		public boolean equals(Object another) {
			if (this == another) {
				return true;
			}
			if (another == null || this.getClass() != another.getClass()) {
				return false;
			}
			Chicken that = (Chicken)another;
			return this.name.equals(that.name) && this.price == that.price;
		}
		
		public int hashCode() {
			StringBuilder builder = new StringBuilder();
			name.chars().forEach(c -> builder.append(c));
			builder.append(price);
			return Integer.parseInt(builder.toString());
		}
		
		public String toString() {
			return new StringBuilder()
					.append(name)
					.append("(")
					.append(price)
					.append(")")
					.toString();
		}
	}
}
