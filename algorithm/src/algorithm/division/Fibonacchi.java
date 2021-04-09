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
	 * ���� ��ȹ��
	 * - ������ ���� ������ ����
	 * - ���� ������ ����κ��� �־� �ߺ����� ����
	 * - �޸����̼� ��� : �ѹ� ���� ���� ������ ���� �� �ٽ� ������� �ʰ� ���
	 */
	int fiboDp(int n) {
		
		int[] cache = new int[n+1]; 
//		cache[0] = 0; // f(0) = 0
		cache[1] = 1; // f(1) = 1
		
		for(int i=2; i<n+1; i++) {
			/*
			 * n == 4 �̸�
			 * f(2) = f(1) + f(0)
			 * f(3) = f(2) + f(1)
			 * f(4) = f(3) + f(2)
			 */
			cache[i] = cache[i-1] + cache[i-2]; // ���ο� ��꿡 �迭�ȿ� �ִ� ��(�̹� ���� ��)�� ���
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
