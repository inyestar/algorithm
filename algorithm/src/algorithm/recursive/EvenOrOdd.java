package algorithm.recursive;

import annotation.Caller;

public class EvenOrOdd extends Caller {

	/**
	 * 임의의 양의 정수 n이 짝수이면 n / 2를 하고, 홀수이면 n * 3 + 1을 n이 1이 될때까지 반복하기
	 * 그 과정을 전부 출력하기
	 * @param integer
	 * @return
	 */
	int makeOne(int n) {
		
		System.out.println(n);
		if(n <= 1) {
			return n;
		}
		n = n % 2 == 0 ? n / 2 : (3*n) + 1;
		return makeOne(n);
	}

	@Override
	public void call(int[] arr) {
		int num = arr[0];
		makeOne(num);
	}

}
