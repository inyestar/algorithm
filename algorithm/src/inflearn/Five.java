package inflearn;

import java.util.Scanner;

public class Five {
	
	public static void main(String [] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			String rnn = scanner.next();
//			String[] rnnArr = rnn.split("-");
//			int temp = Integer.parseInt(rnnArr[1].substring(0, 1));
//			String sex = temp % 2 == 0? "W" : "M";
//			String year = temp < 3 ? "19" : "20";
//			year += rnnArr[0].substring(0, 2);
//			int age = 2019 - Integer.parseInt(year) + 1;
//			System.out.println(age + " " + sex);

			// 숫자 아스키에서 48을 빼면 원래 값을 획득할 수 있음
			int[] rnnArr = rnn.chars().map(x -> x - 48).toArray();
			String sex = rnnArr[7] % 2 == 0 ? "W" : "M";
			int bornYear = (rnnArr[7] < 3 ? 1900 : 2000) + (rnnArr[0] * 10) + rnnArr[1];
			int age = 2019 - bornYear + 1;
			System.out.println(age + " " + sex);
			
		}
	}
}
