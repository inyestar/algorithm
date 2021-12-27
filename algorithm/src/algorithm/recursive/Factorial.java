package algorithm.recursive;

public class Factorial {

	/*
	 * n!
	 */
	static int factorialByRecursive(int n) {
		if(n <= 1) {
			return n;
		}
		return n * factorialByRecursive(n - 1);
	}
	
	static int factorialByLoop(int n) {
		int sum = 1;
		for(int i=n; i>1; i--) {
			sum *= i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(factorialByRecursive(4));
		System.out.println(factorialByLoop(4));
	}

}
