package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

	/*
	 * 버블 정렬
	 * - 정의 : 옆에 있는 값과 비교해서 더 작은 값을 앞으로 보낸다. 
	 *   가장 효율성이 떨어지는 알고리즘이다.
	 *   한 번의 정렬이 끝나면 가장 큰 값이 맨 뒤로 간다.
	 *   계속 자리를 바꾸는 연산을 하기때문에 선택 정렬보다 느리다.
	 * - 시간복잡도 : 10 + 9 + 8 + .. + 1
	 * 	 -> (등차수열) N(N + 1) / 2
	 *   -> O(N^2)
	 */
	public static void main(String[] args) {
		
		int[] input = new int[] {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		
		for(int i=0; i<input.length; i++) {
			for(int j=1; j < input.length - i; j++) {
				// input[j] > input[j+1]
				if(input[j] < input[j-1]) {
					// swap
					int temp = input[j-1];
					input[j-1] = input[j];
					input[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(input));
	}
}
