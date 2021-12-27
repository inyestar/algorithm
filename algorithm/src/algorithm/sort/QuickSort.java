package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

	/*
	 * 퀵 정렬
	 * - 정의 : 분할 정복 알고리즘을 사용 한다.
	 * 	 pivot(기준 값)을 기준으로 왼쪽과 오른쪽으로 나눈다.
	 *   가장 앞의 숫자를 피벗 값으로 사용한다.
	 *   왼쪽에서 오른쪽으로 이동할 때는 pivot보다 큰 값을 선택하고 오른쪽에서 왼쪽으로 이동할때는  pivot보다 작은 값을 선택한다.
	 *   그리고 큰 값과 작은 값을 바꿔준다.
	 *   큰 값과 작은 값을 변경할 때 엇갈린 경우(작은 값이 큰 값보다 이미 외쪽에 존재), pivot과 작은 값의 위치를 바꾼다. 
	 *   위 경우를 분할되었다고 하는데 한 번 분할되면 pivot을 기준으로 왼쪽은 pivot보다 작고 오른쪽은 큰 값으로 이루어진다.
	 * - 시간복잡도 : O(NlogN)
	 *   but 최악의 경우에는 O(N^2) -> 예) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 이미 정렬이 되어 있으면 분할 정복의 이점이 없음
	 */
	static void quickSort(int[] args, int start, int end) {
		
		if(end <= start) {
			// 원소가 1개
			return;
		}
		
		int pivot = start;
		int i = start + 1; // pivot 다음부터
		int j = end;
		
		while(i <= j) {
			// 엇갈릴때까지 = 큰 값의 인덱스가 작은 값의 인덱스보다 작을때
			// 왼 -> 오 : 큰거
			while(args[i] <= args[pivot] && i < end) {
				// pivot보다 큰 값을 만날때까지
				i++;
			}
			
			// 오-> 왼 : 작은거
			while(args[pivot] <= args[j] && j > start) {
				// pivot보다 작은 값을 만날때까지
				j--;
			}
			
			if(i >= j) {
				// 엇갈리면 키 교체
				int temp = args[j];
				args[j] = args[pivot];
				args[pivot] = temp;
			} else {
				int temp = args[j];
				args[j] = args[i];
				args[i] = temp;
			}
		}
		
		// 엇갈릴때 while을 빠져나오니까
		quickSort(args, start, j - 1);
		quickSort(args, j + 1, end);
		
	}
	
	public static void main(String[] args) {

		int[] input = new int[] {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};
//		int[] input = new int[] {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		quickSort(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));
	}

}
