package algorithm.division;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import annotation.Caller;

public class MergeSort extends Caller{
	
	/**
	 * 병합 정렬은 분할 정복 알고리즘의 하나로 더이상 분리가 안될 때까지 리스트를 반으로 쪼개서 비교한 후 다시 합치는 알고리즘
	 * 시간복잡도는 O(n log n)
	 * 
	 * 리스트를 두 개로 쪼깨는 메소드
	 * 더이상 분리할 수 없을 때까지 쪼갠다.
	 * @param list
	 * @return
	 */
	public List<Integer> split(List<Integer> list) {
		
		// 분리가 불가능한 경우
		if(list.size() <= 1) {
			return list;
		}
		
		int offsetForFront = Math.round(list.size() / 2.0f);
		
		List<Integer> front = new ArrayList<>();
		List<Integer> back = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			if(i < offsetForFront) {
				front.add(list.get(i));
				continue;
			} 
			back.add(list.get(i));
		}
		
		return merge(split(front), split(back));
	}

	/**
	 * 쪼갠 데이터를 합치는 메소드
	 * 작은 데이터가 맨 앞에 와야함
	 * @param list
	 * @return
	 */
	private List<Integer> merge(List<Integer> front, List<Integer> back) {
		
//		System.out.printf("front=%s, back=%s%n", front, back);
		List<Integer> mergedList = new ArrayList<>();
		
		int fp = 0;
		int bp = 0;
		
		// case 1 : front, back 둘 다 남아 있을 때
		while(fp < front.size() && bp < back.size()) {
			if(front.get(fp) < back.get(bp)) {
				mergedList.add(front.get(fp++));
			} else {
				mergedList.add(back.get(bp++));
			}
		}
		
		// case 2 : front만 남아 있을 때
		while(fp < front.size()) {
			mergedList.add(front.get(fp++));
		}
		
		// case 3 : back만 남아 있을 때
		while(bp < back.size()) {
			mergedList.add(back.get(bp++));
		}
		
		return mergedList;
	}
	
	@Override
	public void call(int[] arr) {
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.printf(">>>>>>>>>>>>>>>>>>>>> result=%s%n", split(list).toString());
	}

}
