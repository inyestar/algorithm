package inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Eleven {
	
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			int cnt = 0;
			if (N > 9) {
				cnt += 9;
				Map<Integer, Integer> counter = new HashMap<>();
				for(int i=10; i<=N; i++) {
					int tmp = i;
					while(tmp > 0) {
//						int remainder = tmp % 10;
//						counter.put(remainder, counter.getOrDefault(remainder, 0) + 1);
//						tmp /= 10;
						// 굳이 숫자별로 카운트할 필요가 없이 자릿수만큼만 돌면 됨
						tmp /= 10;
						cnt++;
					}
				}
//				cnt += counter.values().stream().reduce((a, b) -> a + b).get();
			} else {
				cnt = N;
			}
			
			System.out.println(cnt);
			
		}

	}

}
