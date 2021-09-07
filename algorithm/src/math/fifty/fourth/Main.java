package math.fifty.fourth;

public class Main {

	public static void main(String[] args) {

		int x = 9;
		int y = 14;
		
		System.out.printf("gcd = %d%n", PrimeNumberUtils.findGreatestCommonDivisor(x, y));
		System.out.printf("lcm = %d%n", PrimeNumberUtils.findLeastCommonMultiple(x, y));
		System.out.printf("isCoprime = %b", PrimeNumberUtils.isCoprime(x, y));
	}

}
