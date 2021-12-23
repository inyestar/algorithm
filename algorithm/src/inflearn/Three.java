package inflearn;

import java.util.Scanner;

public class Three {

	// 진약수 : 자기 자신을 포함하지 않은 약수
	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			int X = scanner.nextInt();
			int sum = 1;
			StringBuilder builder = new StringBuilder();
			builder.append(sum);
			for(int i=2; i<X; i++) {
				if(X % i == 0) {
					sum += i;
					// 위에서 1부터 출력했으니까 패턴이 바뀔 수 있음
					builder.append("+");
					builder.append(i);
				}
			}
//			builder.deleteCharAt(builder.length() - 1);
			String result = builder.append("=").append(sum).toString();
			System.out.println(result);
			
		}
	}

}
