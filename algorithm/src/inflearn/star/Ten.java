package inflearn.star;

import java.util.Arrays;
import java.util.Scanner;

public class Ten {
	
	private static int digitSum(int x) {
//		return String.valueOf(x).chars().map(y -> y - 48).reduce((a, b) -> a + b).getAsInt();

		int tmp = 0;
		int sum = 0;
		while(x > 0) {
			// 한 자리씩 가져오니까 10인가봐 두자리씩 하면 100하면 되네..
			tmp = x % 10;
			sum += tmp;
			x /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int length = scanner.nextInt();
			int[] arr = new int[length];
			int idx = 0;
			while(idx < length) {
				arr[idx++] = scanner.nextInt();
			}
			
//			IntStream.range(0, arr.length).map(x -> digitSum(arr[x])).forEach(System.out::println);
			int result = Arrays.stream(arr).reduce((a, b) -> {
				System.out.println(a + " " + b);
				int sumA = digitSum(a);
				int sumB = digitSum(b);
				
				if (sumA == sumB) {
					return a < b ? b : a;
				}
				
				return sumA < sumB ? b : a;
			}).getAsInt();
			System.out.println(result);
		}
	}

}
