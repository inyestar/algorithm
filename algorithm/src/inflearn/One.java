package inflearn;

import java.util.Scanner;

public class One {

	public static void main(String [] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			
			int cnt = 0;
			int[] nm = new int[2];
			
			while(cnt < nm.length) {
				nm[cnt++] = scanner.nextInt();
			}
			
			int n = nm[0];
			int m = nm[1];
			int sum = 0;
			for(int i=1; i<=n; i++) {
				if (i % m == 0) {
					sum += i;
				}
			}
			
			System.out.println(sum);
		}
	}
}
