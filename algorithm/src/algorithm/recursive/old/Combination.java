package algorithm.recursive.old;

import annotation.Caller;

public class Combination extends Caller {

	/**
	 * 임의의 정수 n을 1,2,3으로 조합하여 임의의 정수 n을 나타내는 경우의 수 구하기
	 * 예) 임의의 수 4는 아래와 같이 조합될 수 있다.
	 * 1+1+1+1,
	 * 2+1+1,
	 * 1+2+1,
	 * 1+1+2,
	 * 3+1,
	 * 1+3,
	 * 2+2 
	 * @param integer
	 * @return
	 */
	int findCombi(int n) {
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		if (n == 3) {
			return 4;
		}
		
		return findCombi(n - 1) + findCombi(n - 2) + findCombi(n -3);
	}
	
	@Override
	public void call(int[] arr) {
		int num = arr[0] > 10? arr[0] % 10 : arr[0];
		int result = findCombi(num);
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result=%s%n", result);
	}

}
