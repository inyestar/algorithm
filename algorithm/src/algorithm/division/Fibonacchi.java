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
	 * 동적계획법
	 * - 큰 문제를 작은 문제로 분할
	 * - 분할된 작은 문제들은 중복됨
	 * - 메모제이션 기법 : 한 번 계산된 작은 문제들은 저장하여 다시 계산하지 않고 이후 계산에 사용
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
			cache[i] = cache[i-1] + cache[i-2]; // 이후 계산에 저장된 값(이미 계산된 값)을 사용하고 있음
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
