package algorithm.recursive;

import algorithm.annotation.Callee;

public class Factorial extends Callee {
	
	/**
	 * n!
	 * �ð� ���⵵ : n-1 �ݺ��� ȣ���� �Ͱ� �����Ͽ� O(n-1) > O(n)
	 * ���� ���⵵ : �Լ��� ȣ���� �� ���� �������� n�� �����ǹǷ� O(n)
	 */
	int recursive1(int n) {
		return n > 1? n * recursive1(n-1) : n;
	}
	
	int recursive2(int n) {
		if(n <= 1) {
			return n;
		}
		return n * recursive2(n-1);
	}
	
	@Override
	public void doCall(int[] arr) {
		
		int param = arr[0] > 10 ? 10 : arr[0];
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result1=%d%n", recursive1(param));
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result2=%d%n", recursive2(param));
		
	}

}
