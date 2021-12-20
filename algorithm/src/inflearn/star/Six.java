package inflearn.star;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Six {

	public static void main(String [] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			String input = scanner.next();
			int number = input
					.chars()
					.filter(x -> x > 47 && x < 58)
					.map(x -> x - 48)
					// 1의 자리에 추가가 되서 곱하기 10을 해서 빈칸을 만들어주는 건가?
					.reduce((a, b) -> a * 10 + b)
					.getAsInt();
			
			// number + 1 은 자기자신을 포함시키기 위해
			long cnt = IntStream.range(1, number + 1).filter(x -> number % x == 0).count();
			
			System.out.println(number);
			System.out.println(cnt);
		}
	}
}
