package algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			int length = scanner.nextInt();
			int[] duration = new int[length];
			int idx = 0;
			while(idx < length) {
				duration[idx++] = scanner.nextInt();
			}
			
			Arrays.sort(duration);
			Arrays.parallelPrefix(duration, Integer::sum);
			
			System.out.println(Arrays.toString(duration));
		}
	}

}
