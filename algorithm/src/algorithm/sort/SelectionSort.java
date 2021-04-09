package algorithm.sort;

import java.util.Arrays;

import annotation.Caller;

public class SelectionSort extends Caller {

	/**
	 * 주어진 데이터 중 최소값을 찾아서 맨 앞에 있는 데이터와 swap
	 * 맨 앞부터 정렬이 됨
	 */
	@Override
	public void call(int[] arr) {
		for(int i=0; i<arr.length - 1; i++) {
			int lowest = i;
			for(int j=i+1; j<arr.length; j++) {
//				System.out.printf("arr[%d]=%d, arr[%d]=%d%n", lowest, arr[lowest], j, arr[j]);
				if(arr[lowest] > arr[j]) {
					lowest = j;
				}
			}
			if(lowest != i) {
				int temp = arr[i];
				arr[i] = arr[lowest];
				arr[lowest] = temp;
			}
//			System.out.println(Arrays.toString(arr));
		}
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result=%s%n", Arrays.toString(arr));
	}
}
