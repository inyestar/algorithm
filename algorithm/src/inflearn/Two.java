package inflearn;

import java.util.Scanner;

public class Two {

	public static void main(String [] args) {
		int [] AB = new int[2];
		try(Scanner scanner = new Scanner(System.in)) {
			int idx = 0;
			while (idx < 2) {
				AB[idx++] = scanner.nextInt();
			}
		}
		
		int A = AB[0];
		int B = AB[1];
		int sum = 0;
		
		StringBuilder builder = new StringBuilder();
		for(; A<=B; A++) {
			builder.append(A);
			sum += A;
			if(A<B) {
				builder.append("+");
			}
		}
		
		String result = builder.append("=").append(sum).toString();
		System.out.println(result);
	}
}
