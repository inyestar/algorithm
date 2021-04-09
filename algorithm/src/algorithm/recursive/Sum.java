package algorithm.recursive;

import java.util.Arrays;

import annotation.Caller;

public class Sum extends Caller{

	/**
	 * 임의의 배열의 원소들의 합
	 * @param args
	 */
	int loop(int[] arr) {
		int temp = 0;
		for(int i : arr) {
			temp += i;
		}
		return temp;
	}
	
	int recursive(int[] arr) {
		int len = arr.length;
		if(len == 1) {
			return arr[0];
		}
//		return arr[len - 1] + recursiveSum(Arrays.stream(arr, 0, len - 1).toArray());
		return arr[0] + recursive(Arrays.stream(arr).skip(1).toArray());
	}

	@Override
	public void call(int[] arr) {
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result-loop=%d%n", loop(arr));
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result-recursive=%d%n", recursive(arr));
		
	}
	
}
