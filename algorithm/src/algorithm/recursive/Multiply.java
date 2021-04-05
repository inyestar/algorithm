package algorithm.recursive;

import algorithm.annotation.Callee;

public class Multiply extends Callee{

	/**
	 * 1���� n���� ���ϴ� �Լ�
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
	public void doCall(int[] arr) {
		int param = arr[0] > 10 ? arr[0] % 10 : arr[0];
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result-loop=%d%n", loop(param));
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result-recursive=%d%n", recursive(param));
		
	}
}
