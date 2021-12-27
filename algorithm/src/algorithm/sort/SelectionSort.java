package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

	/*
	 * 선택 정렬
	 * - 정의 : 가장 작은 것을 선택해서 제일 앞으로 보낸다.
	 * 	 한 번의 정렬이 끝나면 가장 작은 값이 맨 앞으로 간다.
	 * - 시간복잡도 : 10 + 9 + 8 + .. + 1 (등차수열)
	 *   -> 10 * (10 + 1) / 2 = 55 
	 *   -> N * (N + 1 ) / 2
	 *   -> N * N 
	 *   -> O(N^2)
	 */
	public static void main(String[] args) {
		
		int[] input = new int[] {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		for(int i=0; i<input.length; i++) {
			// min = 9999; 가장 큰 값을 넣어줌
			int min = input[i];
			int minIndex = i;
			for(int j= i + 1; j<input.length; j++) {
				if(input[j] < min) {
					min = input[j];
					minIndex = j;
				}
			}
			// swap
			if(minIndex != i) {
				int temp = input[i];
				input[i] = input[minIndex];
				input[minIndex] = temp;
			}
		}
		System.out.println(Arrays.toString(input));
	}

}
