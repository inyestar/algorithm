package inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seventeen {

	/*
	 * T(n) = n(n+1)/2
	 * T(1) -> o		-> o 
	 * 
	 * T(2) -> o		-> o oo		-> 2 X 3 삼각형		-> 넓이는 2X3/2 = 3
	 * 		   oo		   oo o
	 * 
	 * T(3) -> o		-> o ooo	-> 3 X 4 삼각형		-> 넓이는 3X4/2 = 6
	 * 		   oo		   oo oo
	 *		   ooo		   ooo o
	 *
	 * T(4) -> o		-> o oooo	-> 4 X 5 삼각형		-> 넓이는 4X5/2 = 10
	 * 		   oo		   oo ooo
	 * 		   ooo		   ooo oo
	 * 		   oooo		   oooo o
	 * ...
	 * 	
	 */		
	
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<Answer> answerList = new ArrayList<>();
			while(n-- > 0) {
//				answerList.add(sventeen.newAnswer(scanner.nextInt(), scanner.nextInt()));
				answerList.add(new Answer(scanner.nextInt(), scanner.nextInt()));
			}
			
			answerList.stream()
			.map(x -> x.getNumber() * (x.getNumber() + 1) / 2 == x.getExpectedAnswer() ? "YES" : "NO")
			.forEach(System.out::println);
		}
	}

	
	// static class는 static 클래스만 상속 받을 수 있음 따라서 outer class도 static이 안붙었지만 static >  일반적인 class는 static클래스 > nonstatic class는 inner class에서만 가능하다.
	// static class의 인스턴스는 각각 다르다.
	static class Answer /* extends Seventeen */{
		
		private int number;
		
		private int expectedAnswer;
		
		Answer(int number, int expectdAnswer) {
			this.number = number;
			this.expectedAnswer = expectdAnswer;
		}
		
		int getNumber() {
			return number;
		}
		
		int getExpectedAnswer() {
			return expectedAnswer;
		}
		
		public String toString() {
			return "(" + number + "," + expectedAnswer + ")";
		}
	}
}
