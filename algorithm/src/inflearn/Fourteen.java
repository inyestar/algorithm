package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Fourteen {

	static int reverse(int x) {
		
		int y = 0;
		while(x > 0) {
			int remainder = x % 10;
			y = y * 10 + remainder;
			x /= 10;
		}
		
		return y;
	}
	
	static boolean isPrime(int x) {
		
		if(x == 1) {
			// 1은 소수가 아니다.
			return false;
		}
		
		for(int i=2; i<x; i++) {
			if(x % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String [] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int[] input = new int[scanner.nextInt()];
			int cnt = 0;
			while(cnt < input.length) {
				input[cnt++] = scanner.nextInt();
			}
			
			Arrays.stream(input).map(Fourteen::reverse).filter(Fourteen::isPrime).forEach(System.out::println);
			
		}
	}
}
