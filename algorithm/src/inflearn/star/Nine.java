package inflearn.star;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Nine {
	
	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
//			for(int i = 1; i <= N; i++) {
//				int cnt = 0;
//				for(int j=i; j<=N; j++) {
//					if(j % i == 0) cnt++;
//				}
//				System.out.println(cnt);
//			}
			
//			for(int i=1; i<=N; i++) {
//				for(int j=i; j<=N; j += i) {
//					System.out.print(j + " ");
//				}
//				System.out.println();
//			}
			
			int[] answer = new int[N];
			IntStream.range(1, N + 1).forEach(i -> {
				// 2는 2의 배수에 대해 약수
				// 3은 3의 배수에 대해 약수
				// i가 3이면 j += i는 3+3이 되서 6이 됨
				for(int j=i; j<=N; j += i) {
					if(j % i == 0) answer[j-1]++;
				}
			});
			
			System.out.println(Arrays.toString(answer));
		}			
	}

}
