package algorithm.division;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import annotation.Caller;
import annotation.Run;

@Run
public class QuickSort extends Caller {

	/**
	 * Quick 정렬은 분할 정복 알고리즘 중 하나
	 * 기준점을 정해서 기준점보다 작은 데이터는 왼쪽, 큰 데이터는 오른쪽
	 * - pivot : 기준점
	 * - left : pivot 보다 작은 값들
	 * - right : pivot 보다 큰 값들
	 * - 반복은 재귀 함수로 처리
	 * >> 시간 복잡도는 n log n 이나 최악의 경우 pivot이 가장 크거나 가장 작으면 모든 데이터를 비교해야하기 때문에 n^2가 됨
	 */
	private List<Integer> quickSort(List<Integer> list) {

		if(list.size() <= 1) {
			return list;
		}
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		Integer pivot = list.get(0);
		for(int i=1; i<list.size(); i++) {
			if (pivot > list.get(i)) {
				left.add(list.get(i));
			} else {
				right.add(list.get(i));
			}
		}
		
		System.out.printf("left=%s + pivot=[%d] + right=%s%n", left.toString(), pivot, right.toString());
		
		// return quickSort(left) + pivot + quickSort(right)
		return Stream.of(quickSort(left).stream(), Stream.of(pivot), quickSort(right).stream()).flatMap(Function.identity()).collect(Collectors.toList());
	}
	
	@Override
	public void call(int[] arr) {
		
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result=%s%n", quickSort(Arrays.stream(arr).boxed().collect(Collectors.toList())).toString());
	}

}
