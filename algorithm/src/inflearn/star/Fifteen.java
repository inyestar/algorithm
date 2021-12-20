package inflearn.star;

import java.util.Scanner;

public class Fifteen {
	
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int result = 0;
			for(int i=2; i<=n; i++) {
				System.out.print(i + " : ");
				int cnt = 0;
				// 1 * 36
				// 2 * 18
				// 3 * 12
				// 4 * 9
				// 6 * 6  --> 6 까지만 보면 됨 그래서 제곱근을 만족시키기 위한 조건문으로 6 * 6 <= 36을 확인
				for(int j=2; j*j<=i; j++) {
					System.out.print(j + " ");
					if(i % j == 0) {
						cnt++;
						break;
					}
				}
				System.out.println();
				if(cnt == 0) {
					result++;
				}
			}
			System.out.println(result);
		}
	}

}
