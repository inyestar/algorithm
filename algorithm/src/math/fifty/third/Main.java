package math.fifty.third;

public class Main {

	public static void main(String[] args) {
		/*
		 * 분수 나누기
		 */
		Fraction x = new Fraction(5, 7);
		Fraction y = new Fraction(4, 5);
		System.out.println(x.divide(y));
		
		/*
		 * 소수 계산
		 */
		float a = 0.23f;
		float b = 0.45f;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
	}

}
