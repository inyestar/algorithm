package inflearn;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Seven {

	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			String abnormal = scanner.nextLine();
			String normal = abnormal.chars()
							.filter(x -> x != 32) // 32는 space
							.map(x -> x < 97 ? x + 32 : x)
							// map은 안됨..
							.mapToObj(x -> Character.toString((char) x))
							.collect(Collectors.joining());
			System.out.println(normal);
		}
	}

}
