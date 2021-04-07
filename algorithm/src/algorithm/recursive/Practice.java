package algorithm.recursive;

public class Practice {

	/**
	 * ������ ���� ���� n�� ¦���̸� n / 2�� �ϰ�, Ȧ���̸� n * 3 + 1�� n�� 1�� �ɶ����� �ݺ��ϱ�
	 * �� ������ ���� ����ϱ�
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
	 * ������ ���� n�� 1,2,3���� �����Ͽ� ������ ���� n�� ��Ÿ���� ����� �� ���ϱ�
	 * ��) ������ �� 4�� �Ʒ��� ���� ���յ� �� �ִ�.
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
