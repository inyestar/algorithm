package math.fifty.second;

/**
 * 분수를 표현하기 위한 객체
 * @author inye
 *
 */
public class Fraction {

	int numerator; // 분자
	int denominator; // 분모
	
	/**
	 * First argument is numerator<br/>
	 * Second argument is denominator
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator) {
		
		if (denominator <= 0) {
			throw new ArithmeticException("Denominator should be greater than zero");
		}
		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	private int getNumerator() {
		return numerator;
	}
	
	private int getDenominator() {
		return denominator;
	}
	
	/**
	 * 분수 더하기, 빼기 계산
	 * @param x1
	 * @param x2
	 * @return
	 */
	public Fraction add(Fraction y) {
		
		// 분모가 다르면 통분
		if (this.denominator != y.getDenominator()) {
			int leastCommonMultiple = NaturalNumberUtils.findLeastCommonMultiple(this.denominator, y.getDenominator());
			int xTop = this.numerator * (leastCommonMultiple / this.denominator);
			int yTop = y.getNumerator() * (leastCommonMultiple / y.denominator);
			return new Fraction(xTop + yTop, leastCommonMultiple);
		}
		
		return new Fraction(this.numerator + y.getNumerator(), this.denominator);
	}
	
	/**
	 * 분수 곱셈
	 * @param y
	 * @return
	 */
	public Fraction multiply(Fraction y) {
		
		int top = this.numerator * y.getNumerator();
		int bottom = this.denominator * y.getDenominator();
		
		NaturalNumber tN = new NaturalNumber(top);
		NaturalNumber bN = new NaturalNumber(bottom);
		
		// 기약분수
		if (tN.isPrimeNumber() && bN.isPrimeNumber()) {
			return new Fraction(top, bottom);
		}
		
		// 약분이 필요한 경우
		int greatCommonDivisor = NaturalNumberUtils.findGreatCommonDivisor(tN, bN);
		
		return new Fraction(top/greatCommonDivisor, bottom/greatCommonDivisor);
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s", numerator, denominator);
	}
}
