package algorithm.division;

import java.util.Arrays;

public class Fibonacchi {
	
	int fibo(int n) {
		if(n <= 1) {
			return n; // 1 or 0
		}
		return fibo(n-1) + fibo(n-2);
	}

	/*
	 * 동적 계획법
	 * - 문제를 작은 단위로 분할
	 * - 작은 단위는 공통부분이 있어 중복으로 사용됨
	 * - 메모제이션 기법 : 한번 계산된 작은 단위는 저장 후 다시 계산하지 않고 사용
	 */
	int fiboDp(int n) {
		
		int[] cache = new int[n+1]; 
//		cache[0] = 0; // f(0) = 0
		cache[1] = 1; // f(1) = 1
		
		for(int i=2; i<n+1; i++) {
			/*
			 * n == 4 이면
			 * f(2) = f(1) + f(0)
			 * f(3) = f(2) + f(1)
			 * f(4) = f(3) + f(2)
			 */
			cache[i] = cache[i-1] + cache[i-2]; // 새로운 계산에 배열안에 있는 값(이미 계산된 값)을 사용
		}
		
		System.out.println(Arrays.toString(cache));
		
		return cache[n];
	}
	
	public static void main(String[] args) {
		
		Fibonacchi dp = new Fibonacchi();
		System.out.println(dp.fibo(4));
		System.out.println(dp.fiboDp(4));
		
	}

}
