package inflearn;

import java.util.Scanner;

public class Eleven {
	
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			int cnt = 0;
			if (N > 9) {
				cnt += 9;
				for(int i=10; i<=N; i++) {
					int tmp = i;
					while(tmp > 0) {
						// 굳이 숫자별로 카운트할 필요가 없이 자릿수만큼만 돌면 됨
						tmp /= 10;
						cnt++;
					}
				}
			} else {
				cnt = N;
			}
			
			System.out.println(cnt);
			
		}

	}

}
