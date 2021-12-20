package inflearn;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Thirteen {
	
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
//			long n = scanner.nextLong();
//			
//			int[] arr = new int[10];
//			while(n > 0) {
//				arr[(int) (n % 10)]++;
//				n /= 10;
//			}
//			
//			int result = IntStream.range(0, arr.length).reduce((a, b) -> {
//				if(arr[a] == arr[b]) {
//					return a < b ? b : a;
//				}
//				return arr[a] < arr[b] ? b : a;
//			}).getAsInt();
//			
//			System.out.println(result);
			
			// 자릿수가 100이 니까 숫자로 읽을 수는 없고 String으로 읽어야함
			String n = scanner.next();
			int[] arr = new int[10];
			n.chars().forEach(x -> arr[x-48]++);
			int result = IntStream.range(0, 10).reduce((i, j) -> arr[i] == arr[j] ? (i < j ? j : i) : (arr[i] < arr[j] ? j : i)).getAsInt();
			System.out.println(result);
		}
	}

}
