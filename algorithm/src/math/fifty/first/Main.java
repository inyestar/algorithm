package math.fifty.first;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 분수 더하기
		 */
		Fraction x = new Fraction(5, 7);
		Fraction y = new Fraction(-1, 7);
		System.out.println(x.add(y));
		
		/*
		 * 약수, 소수, 인수분해, 소인수분해
		 */
		NaturalNumber num = new NaturalNumber(192);
		System.out.println(num.isPrimeNumber());
		System.out.println(num.factorize());
		System.out.println(num.factorizeInPrimeFactors());
		System.out.println(num.getNumberOfFactorization());
	}

}
