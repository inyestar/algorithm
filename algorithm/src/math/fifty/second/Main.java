package math.fifty.second;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 분수 더하기/곱셈
		 */
		Fraction x = new Fraction(5, 7);
		Fraction y = new Fraction(4, 5);
		System.out.println(x.add(y));
		System.out.println(x.multiply(y));
		
		/*
		 * 공배수, 최소 공배수, 공약수, 최대 공약수
		 */
		NaturalNumber a = new NaturalNumber(8);
		NaturalNumber b = new NaturalNumber(12);
		System.out.println(NaturalNumberUtils.findCommonDivisorsBeautifully(a, b));
		System.out.println(NaturalNumberUtils.findGreatCommonDivisor(a, b));
		System.out.println(NaturalNumberUtils.findLeastCommonMultiple(a, b));
		System.out.println(NaturalNumberUtils.findCommonMultiple(a, b, 100, 20));
		
	}

}
