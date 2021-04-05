package algorithm.sort;

import java.util.Arrays;

import algorithm.annotation.Callee;

public class SelectionSort extends Callee {

	/*
	 * �־��� ������ �� �ּҰ��� ã�Ƽ� �� �տ� �ִ� �����Ϳ� swap
	 * �� �պ��� ������ ��
	 */
	@Override
	public void doCall(int[] arr) {
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
