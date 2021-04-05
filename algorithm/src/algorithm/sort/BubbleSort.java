package algorithm.sort;

import java.util.Arrays;

import algorithm.annotation.Callee;

public class BubbleSort extends Callee{

	/*
	 * n�� n+1�� ���Ͽ� n�� n+1���� ũ�� swap
	 * �������� ū ���ں��� ������ �Ǳ� ������ �� ����� �迭�� ũ�Ⱑ -i ��ŭ �پ��� ��
	 */
	@Override
	public void doCall(int[] arr) {
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
