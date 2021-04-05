package algorithm.sort;

import java.util.Arrays;

import algorithm.annotation.Callee;

public class InsertSort extends Callee {

	/*
	 * n과 n-1을 비교하여 n이 더 작으면 n-1로 이동
	 * n-1보다 크면 앞의 데이터 모두 정렬이 되었다고 가정하고 break;
	 * 
	 */
	@Override
	public void doCall(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>0; j--) {
//				System.out.printf("arr[%d]=%d, arr[%d]=%d%n",j, arr[j], j-1, arr[j-1]);
				if(arr[j-1]>arr[j]) {
 					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				} else {
					break;
				}
			}
			
//			System.out.println(Arrays.toString(arr));
			
		} 
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result=%s%n", Arrays.toString(arr));
	}

}
