package algorithm.recursive;

import algorithm.annotation.Callee;

public class Factorial extends Callee {
	
	/**
	 * n!
	 * 시간 복잡도 : n-1 반복문 호출한 것과 동일하여 O(n-1) > O(n)
	 * 공간 복잡도 : 함수를 호출할 때 마다 지역변수 n이 생성되므로 O(n)
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
