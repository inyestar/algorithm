package algorithm.recursive;

public class Summary {

	/*
	 * n(n + 1)/2
	 */
	static int sum(int n) {
		return n * (n + 1) / 2; 
	}
	public static void main(String[] args) {
		System.out.println(sum(10));
	}

}
