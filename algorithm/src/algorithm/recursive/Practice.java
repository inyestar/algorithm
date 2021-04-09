package algorithm.recursive;

public class Practice {

	/**
	 * 임의의 양의 정수 n이 짝수이면 n / 2를 하고, 홀수이면 n * 3 + 1을 n이 1이 될때까지 반복하기
	 * 그 과정을 전부 출력하기
	 * @param integer
	 * @return
	 */
	int makeOne(int n) {
		
		if(n <= 1) {
			return n;
		}
		n = n % 2 == 0 ? n / 2 : (3*n) + 1;
		System.out.println(n);
		return makeOne(n);
	}
	
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
	int findNumber(int n) {
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		if (n == 3) {
			return 4;
		}
		
		return findNumber(n - 1) + findNumber(n - 2) + findNumber(n -3);
		
	}

	public static void main(String[] args) {
		
		Practice o = new Practice();
//		o.makeOne(3);
		System.out.println(o.findNumber(6));

	}

}
