package algorithm.greedy;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Coin {
	
	private static int accounts = 4720;

	public static void main(String[] args) {

		IntStream.of(1, 100, 50, 500)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.forEach(x -> {
					System.out.print(x + "=");
					System.out.print(accounts / x);
					accounts %= x;
					System.out.println();
				});
	}

}
