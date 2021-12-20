package inflearn;

import java.util.Arrays;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Sixteen {
	
	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			String w1 = scanner.next();
			String w2 = scanner.next();

			if(w1.length() != w2.length()) {
				throw new RuntimeErrorException(new Error(), "The length of the words is not same");
			}
			
//			System.out.println(Arrays.equals(w1.chars().sorted().toArray(), w2.chars().sorted().toArray()) ? "YES" : "NO");
			
			// 전체 알파벳 갯수
			int[] cnt = new int[52];
			w1.chars().forEach(x -> {
				if (x > 90) {
					cnt[x - 71]++;
				} else {
					cnt[x - 65]++;
				}
			});
			
			System.out.println(Arrays.toString(cnt));
			
			w2.chars().forEach(x -> {
				if (x > 90) {
					cnt[x - 71]--;
				} else {
					cnt[x - 65]--;
				}
			});
			
			// 아니면 cnt를 하나 더 만들어서 두 배열 비교하는 방법도 있음
			
			System.out.println(Arrays.toString(cnt));
			System.out.println(Arrays.stream(cnt).filter(x -> x != 0).count() == 0 ? "YES" : "NO");
		}
	}

}
