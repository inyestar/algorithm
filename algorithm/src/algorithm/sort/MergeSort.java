package algorithm.sort;

import java.util.Arrays;

public class MergeSort {

	/*
	 * 병합 정렬
	 * - 정의 : 일단 반으로 나누고 나중에 합친다. 
	 	 정확하게 반으로 나누기때문에 퀵 정렬과 다르게 NlogN을 항상 보장한다.
	 * - 시간복잡도 : O(NlogN)
	 */
	static int[] sorted = new int[8];
	static void merge(int[] args, int start, int middle, int end) {
		
		int i = start;
		int j = middle + 1;
		int k = start;
		while(i <= middle && j <= end) {
			if(args[i] <= args[j]) {
				sorted[k] = args[i];
				i++;
			} else {
				sorted[k] = args[j];
				j++;
			}
			k++;
		}
		
		// 남은 데이터 삽입
		// i가 먼저 끝나면 j 삽입 필요 반대로 j가 먼저 끝나면 남은 i 삽입 필요
		int leftStart = i > middle ? j : i;
		int leftEnd = i > middle ? end : middle;
		for(int z = leftStart; z <= leftEnd; z++) {
			sorted[k] = args[z];
			k++;
		}
		
		// 정렬된 값을 실제 배열에 담기
		for(int l=start; l<= end; l++) {
			args[l] = sorted[l];
		}
		
	}
	
	static void mergeSort(int[] args, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(args, start, middle);
			mergeSort(args, middle + 1, end);
			merge(args, start, middle, end);
		}
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {7, 6, 5, 8, 3, 4, 9, 1};
		mergeSort(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));
	}

}
