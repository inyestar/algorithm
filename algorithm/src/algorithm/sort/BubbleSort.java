package algorithm.sort;

import java.util.Arrays;

import annotation.Caller;

public class BubbleSort extends Caller{

	/**
	 * n과 n+1을 비교하여 n이 n+1보다 크면 swap
	 * 마지막의 큰 숫자부터 정렬이 되기 때문에 비교 대상인 배열의 크기가 -i 만큼 줄어들게 됨
	 */
	@Override
	public void call(int[] arr) {
		for(int i=0; i<arr.length - 1; i++) {
			boolean swapped = false;
			for(int j=0; j<arr.length - 1 - i; j++) {
//				System.out.printf("arr[%d]=%d, arr[%d]=%d%n", j, arr[j], j+1, arr[j+1]);
				if(arr[j] > arr[j+1]) {
					swapped = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!swapped) {
				break;
			}
//			System.out.println(Arrays.toString(arr));
		}
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result=%s%n", Arrays.toString(arr));
	}

}
