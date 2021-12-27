package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

	/*
	 * 삽입 정렬
	 * - 정의 : 앞의 숫자들이 이미 정렬이 되어있다고 가정한다. 
	 *   필요할 때만 위치를 바꾼다.
	 *   버블, 선택 정렬보다 빠르다.
	 *   자신보다 작으면 멈추면 되니까 멈출 포인트를 알고 있음
	 * - 시간복잡도 : 10 + 9 + .. + 1 = 55
	 *   -> O(N^2)
	 *   -> but 거의 정렬이 되어 있다면 (2, 3, 4, 5, 6, 7, 8, 9, 10, 1) -> O(N)
	 */
	public static void main(String[] args) {
		
		int[] input = new int[] {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
//		for(int i=1; i<input.length; i++) {
//			int num = input[i];
//			int index = i;
//			for(int j=i - 1; j >= 0; j--) {
//				if(num < input[j]) {
//					int temp = input[j];
//					input[j] = num;
//					input[index] = temp;
//					// i의 변한 위치를 알려주지 않으면 계속 i의 고정 값으로만 swap
//					index = j;
//				}
//			}
//		}
		
		// 답안
		for(int i=1; i<input.length; i++) {
			int j = i;
			// i = 1,
			// j = 1, 0
			// i - 2,
			// j = 2, 1
			//	 = 1, 0
			// i = 3,
			// j = 3, 2
			//   = 2, 1
			//   = 1, 0
			// ...
			while(input[j] < input[j - 1]) {
				int temp = input[j - 1];
				input[j - 1] = input[j];
				input[j] = temp;
				j--;
			}
		}
		
		System.out.println(Arrays.toString(input));
	}

}
