package inflearn.star;

import java.util.Scanner;

public class Twelve {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int cnt = 0;
			// 1 -> 9개
			// 2 -> 90개
			// 3 -> 900개
			// 4 -> 9000개
			int length = (int) (Math.log10(n) + 1);
			for(int i = 1; i <= length; i++) {
				if (i < length) {
					cnt += 9 * Math.pow(10, i - 1) * i;
					continue;
				}
				cnt += (n - Math.pow(10, length - 1) + 1) * length;
			}
			
			System.out.println(cnt);
			
			/*
			 *    1 -    9 : 1 * 9
			 *   10 -   99 : 2 * 90
			 *  100 -  999 : 3 * 900
			 * 1000 - 9999 : 4 * 9000
			 * ...
			 */
			
			int sum = 0;
			int d = 9;
			int c = 1;
			int res = 0;
			while (sum + d < n) {
				res += c * d;
				sum += d;
				c++;
				d *= 10;
			}
			
			res += (n - sum) * c;
			System.out.println(res);
			
			

		}
	}

}
