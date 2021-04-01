package algorithm.sort;

import java.util.Arrays;

import algorithm.annotation.Run;

public class InsertSort extends Sort {

	/*
	 * n�� n-1�� ���Ͽ� n�� �� ������ n-1�� �̵�
	 * n-1���� ũ�� ���� ������ ��� ������ �Ǿ��ٰ� �����ϰ� break;
	 * 
	 */
	@Override
	public void doSort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>0; j--) {
				System.out.printf("arr[%d]=%d, arr[%d]=%d%n",j, arr[j], j-1, arr[j-1]);
				if(arr[j-1]>arr[j]) {
 					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				} else {
					break;
				}
			}
			
			System.out.println(Arrays.toString(arr));
			
		} 
		
	}

}
