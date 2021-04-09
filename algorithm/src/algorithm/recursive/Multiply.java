package algorithm.recursive;

import annotation.Caller;

public class Multiply extends Caller{

	/**
	 * n 까지 곱한 값
	 * @param n
	 * @return
	 */
	int loop(int n) {
		int temp = 1;
		for (int i=1; i<n+1; i++) {
			temp *= i;
		}
		return temp;
	}
	
	int recursive(int n) {
		
		if(n <= 1) {
			return n;
		}
		return n * recursive(n - 1);
		
	}

	@Override
	public void call(int[] arr) {
		int param = arr[0] > 10 ? arr[0] % 10 : arr[0];
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result-loop=%d%n", loop(param));
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result-recursive=%d%n", recursive(param));
		
	}
}
