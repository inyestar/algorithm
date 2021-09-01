package math.fifty.first;

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
		
		// 분모가 같은지 판단
		if (this.denominator != y.getDenominator()) {
			throw new ArithmeticException("Denominators should be equal");
		}
		
		return  new Fraction(this.numerator + y.getNumerator(), this.denominator);
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s", numerator, denominator);
	}
}
