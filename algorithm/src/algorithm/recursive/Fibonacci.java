package algorithm.recursive;

public class Fibonacci {
	
	/*
	 * 0, 1, 1, 2, 3, 5, 6, 13 .. 
	 * 첫 번째와 두 번째는 0, 1로 고정
	 * n 번째 피보나치 수는 (n - 1 피보나치 수) + (n - 2 피보나치 수)
	 */
	static int fibonacciByRecursive(int n) {
		
		if(n == 1) {
			return 0;
		}
		
		if(n == 2) {
			return 1;
		}
		
		return fibonacciByRecursive(n - 1) + fibonacciByRecursive(n - 2);
	}
	
	static int fibonacciByLoop(int n) {
		
		if(n == 1) {
			return 0;
		}
		
		if(n == 2) {
			return 1;
		}
		
		int n1 = 0;
		int n2 = 1;
		int fib = 0;
		for(int i=2; i<n; i++) {
			fib = n2 + n1;
			n1 = n2;
			n2 = fib;
		}
		
		return fib;
	}

	public static void main(String[] args) {
		System.out.println(fibonacciByRecursive(7));
		System.out.println(fibonacciByLoop(7));
	}

}
