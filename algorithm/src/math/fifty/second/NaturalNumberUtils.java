package math.fifty.second;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NaturalNumberUtils {

	/**
	 * 공약수 구하기
	 * @param x
	 * @param y
	 * @return
	 */
	@Deprecated
	public static List<Integer> findCommonDivisors(NaturalNumber x, NaturalNumber y) {
		
		List<Integer> commonDivisors = new ArrayList<>();
		
		// 서로소
		if(x.isPrimeNumber() && y.isPrimeNumber()) {
			return commonDivisors;
		}
		
		List<Integer> xAliquot = x.factorize();
		List<Integer> yAliquot = y.factorize();
		
		// 1과 자기자신 제외
		for (int i=1; i<xAliquot.size() - 1; i++) {
			for(int j=1; i<yAliquot.size() - 1; j++) {
				if(xAliquot.get(i) == yAliquot.get(j) ) {
					commonDivisors.add(xAliquot.get(i));
				}
			}
		}
		
		return commonDivisors;
	}
	
	/**
	 * 공약수 구하기
	 * 최대 공약수를 구하여 그 수로 약수 구하기
	 * @param x
	 * @param y
	 * @return
	 */
	public static List<Integer> findCommonDivisorsBeautifully(NaturalNumber x, NaturalNumber y) {
		
		return new NaturalNumber(findGreatCommonDivisor(x, y)).factorize();
	}
	
	/**
	 * 최대 공약수 구하기
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findGreatCommonDivisor(NaturalNumber x, NaturalNumber y) {
		
		// 서로소
		if(isRelativePrime(x, y)) {
			throw new ArithmeticException("These are relative prime");
		}
		
		return findGreatCommonDivisor(x.getNumber(), y.getNumber());
	}
	
	/**
	 * Euclid's Algorithm
	 * @param x
	 * @param y
	 * @return
	 */
	private static int findGreatCommonDivisor(int x, int y) {
		
		if (y == 0) {
			return x;
		}
		
		return findGreatCommonDivisor(y, x % y);
	}
	
	/**
	 * 서로소인지 확인
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean isRelativePrime(NaturalNumber x, NaturalNumber y) {
		return x.isPrimeNumber() && y.isPrimeNumber();
	}
	
	/**
	 * 서로소인지 확인
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean isRelativePrime(int x, int y) {
		
		NaturalNumber xN = new NaturalNumber(x);
		NaturalNumber yN = new NaturalNumber(y);
		
		return xN.isPrimeNumber() && yN.isPrimeNumber();
	}
	
	/**
	 * 최소 공배수 구하기
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findLeastCommonMultiple(NaturalNumber x, NaturalNumber y) {
		
		// 서로소
		if(isRelativePrime(x, y)) {
			return x.getNumber() * y.getNumber();
		}
		
		return x.getNumber() * y.getNumber() / findGreatCommonDivisor(x, y);
	}
	
	
	/**
	 * 최소 공배수 구하기
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findLeastCommonMultiple(int x, int y) {
		
		// 서로소
		if(isRelativePrime(x, y)) {
			return x * y;
		}
		
		return x * y / findGreatCommonDivisor(x, y);
	}
	
	/**
	 * 공배수 구하기
	 * @param x
	 * @param y
	 * @param limit
	 * @param cnt
	 * @return
	 */
	public static List<Integer> findCommonMultiple(NaturalNumber x, NaturalNumber y, int limit, int cnt) {
		
		int leastCommonMultiple = findLeastCommonMultiple(x, y);
		
		return IntStream.range(0, cnt).map(i -> i * leastCommonMultiple).filter(i -> i <= limit).boxed().collect(Collectors.toList());
	}

}
