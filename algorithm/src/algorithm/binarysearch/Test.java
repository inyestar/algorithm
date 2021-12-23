package algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Test {
	
	static int[] getInput(int length, Scanner scanner) {
		int[] numbers = new int[length];
		int idx = 0;
		while(idx < length) {
			numbers[idx++] = scanner.nextInt();
		}
		return numbers;
	}
	
	static int searched(int[] numbers, int x) {

		if(numbers == null || numbers.length == 0) {
			return 0;
		}
		
		if(numbers.length == 1) {
			return numbers[0] == x ? 1 : 0;
		}
		
		int divider = numbers.length / 2;
		if(numbers[divider] == x) {
			return 1;
		}
		
		int medium = numbers[divider];
		int length = medium < x ? numbers.length - divider - 1 : divider;
		int startPos = medium < x ? divider + 1 : 0;
		int[] newArr = new int[length];
		System.arraycopy(numbers, startPos, newArr, 0, length);
		return searched(newArr, x);
	}
	
	static int searched(int x, int start, int end) {
		
		if(start >= end) {
			return 0;
		}
		
		int medium = (start + end) / 2;
		int mediumValue = numbers[medium];
		
		
		if(mediumValue == x) {
			return 1;
		}
		
		if(mediumValue < x) {
			return searched(x, medium + 1, end);
		} else {
			return searched(x, start, medium - 1);
		}
	}
	
	static int[] numbers = null;

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			numbers = getInput(scanner.nextInt(), scanner);
			int[] searchs = getInput(scanner.nextInt(), scanner);
			
			Arrays.sort(numbers);
			IntStream.of(searchs)
				.map(x -> {
//					return searched(numbers, x);
					return searched(x, 0, numbers.length);
				})
				.forEach(System.out::println);
			
		}
	}

}
