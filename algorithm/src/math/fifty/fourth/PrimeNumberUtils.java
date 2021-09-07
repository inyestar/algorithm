package math.fifty.fourth;

public class PrimeNumberUtils {

	/**
	 * 두 수의 최대 공약수 구하기
	 * 같은 소수의 지수가 작은 쪽
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findGreatestCommonDivisor(int x, int y) {
		
		int gcd = 1;
		for (int i = 1; i <= x && i <= y; i++) {
			if ( x % i == 0 && y % i == 0) {
				gcd = i;
			}
		}
		
		return gcd;
	}
	
	/**
	 * 두 수의 최소 공배수 구하기
	 * 같은 소수는 지수가 큰 쪽 x 차집합들
	 * x * y = LCM(x, y) * GCD(x, y)
	 * (x * y) / GCD(x, y) = LCM(a, b)
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findLeastCommonMultiple(int x, int y) {
		
		return (x * y) / PrimeNumberUtils.findGreatestCommonDivisor(x, y);
	}
	
	/**
	 * 서로소
	 * 공통인 공약수가 1밖에 없음
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isCoprime(int x, int y) {
		
		return PrimeNumberUtils.findGreatestCommonDivisor(x, y) == 1;
	}
}
