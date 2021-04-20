package algorithm.division;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import annotation.Caller;

public class BinarySearch extends Caller{
	
	/**
	 * 순차 탐색과 다르게 정렬된 아이템 중 중간값을 기준으로
	 * ㄴ 순차탐색은 O(n)
	 * 검색할 값이 작을 경우는 앞 쪽, 큰 경우는 뒤쪽으로 이동하며 범위를 1/2로 줄이는 것 
	 * 이진 탐색은 데이터가 정렬되어 있는 상태에서 시작
	 * 시간복잡도는 O(log n)
	 */
	private boolean findNumber(List<Integer> sortedList, int findData) {
		
		System.out.println(sortedList);
		
		if (sortedList.size() == 1) {
			return sortedList.get(0).intValue() == findData;
		}
		int offset = Math.round(sortedList.size() / 2.0f);
		if(sortedList.get(offset).intValue() == findData) {
			return true;
		}
		if(findData > sortedList.get(offset)) {
			return findNumber(sortedList.stream().skip(offset + 1).collect(Collectors.toList()), findData);
		} 
		return findNumber(sortedList.stream().limit(offset).collect(Collectors.toList()), findData);
	}

	@Override
	public void call(int[] arr) {
		MergeSort sort = new MergeSort();
		List<Integer> sortedList = sort.split(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		boolean hasNumber = findNumber(sortedList, 111);
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result=%b%n", hasNumber);
	}

}
