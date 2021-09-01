package math.fifty.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NaturalNumber {
	
	private static int ONE = 1;
	
	private int number;
	
	public NaturalNumber(int number) {
		if (number <= 0) {
			throw new ArithmeticException("number should be greater than zero");
		}
		this.number = number;
	}
	
	/**
	 * 주어진 숫자가 소수인지 판단
	 * 소수란 1과 자기 자신만이 약수인 수
	 */
	public boolean isPrimeNumber() {
		
		int x = number;
		// 1은 소수가 아님
		if (x <= 1) {
			return false;
		}
		
		// i는 나누기를 위한 값으로 1을 제외하고 2부터 시작
		for (int i=2; i<x; i++) {
			// 1과 자기 자신 이외에 나누어지는 수가 있는지 확인
			if(x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 주어진 숫자의 약수 구하기
	 * 약수란 x * y = 정수에서 x와 y
	 * @param args
	 */
	public List<Integer> factorize() {

		int x = number;
		List<Integer> factors = new ArrayList<>();
		
		factors.add(ONE);
		for (int i=2; i<x; i++) {
			if (x % i == 0) {
				factors.add(i);
			}
		}
		factors.add(x);
		
		return factors;
	}
	
	/**
	 * 주어진 숫자의 소수로 이루어진 약수 구하기
	 * @param naturalNumber
	 * @return
	 */
	public Map<Integer, Long> factorizeInPrimeFactors() {
		
		int x = number;
		List<Integer> factors = new ArrayList<>();
		for (int i=2; i<=x; i++) {
			while( x % i == 0 ) {
				factors.add(i);
				x /= i;
			}
		}
		
		return factors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	/**
	 * 주어진 숫자의 약수의 개수
	 * @param x
	 * @return
	 */
	public int getNumberOfFactorization() {
		return factorizeInPrimeFactors().values().stream().mapToInt(x -> x.intValue() + 1).reduce(1, (a, b) -> a * b);
	}

}
