package algorithm.sort;

import java.util.Arrays;

public class HeapSort {

	/*
	 * 힙 정렬
	 * - 정의 : 힙 트리는 완전 이진 트리
	 * 	 heapify : 하나의 노드에 대해서 부모 노드의 값이 자식 노드의 값 보다 작은 경우 자식 노드의 가장 큰 값을 부모 노드로 옮겨줌
	 * - 시간복잡도 : O(1/2NlogN) -> O(N)
	 *   완전 이진 트리이기 때문에
	 */
	public static void main(String[] args) {
		
		int[] input = new int[] {7, 6, 5, 8, 3, 5, 9, 1, 6};
		
		// 힙 구조로 바꿈
		for(int i=1; i<input.length; i++) {
			int c = i;
			do {
				int p = (c - 1) / 2;
				// 부모의 값보다 자식의 값이 크면
				if(input[p] < input[c]) {
					int temp = input[p];
					input[p] = input[c];
					input[c] = temp;
				}
				c = p;
			} while (c != 0);
		}
		
		// 크기를 줄여가면서 힙 구성
		for(int i=input.length - 1; i >= 0; i--) {
			int temp = input[0]; // 가장 큰 값
			input[0] = input[i]; // 가장 큰 값을 맨 뒤로 보내줌
			input[i] = temp;
			int p = 0;
			int c = 1;
			do {
				c = 2 * p + 1; // 자식
				// 자식중 더 큰 값 찾기
				if(c < i - 1 && input[c] < input[c+1]) {
					c++;
				}
				if(c < i && input[p] < input[c]) {
					int t = input[p];
					input[p] = input[c];
					input[c] = t;
				}
				p = c;
			} while(c < i);
		}
		
		System.out.println(Arrays.toString(input));
	}

}
