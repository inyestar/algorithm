package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Examples {
	
	/*
	 * 탐욕 알고리즘 : 매순간 최적이라고 생각되는 경우를 선택
	 */
	
	private static int totalCount = 0;
	private static int price = 0;
	
	private static void increase(int x) {
		int cnt = price / x;
		totalCount += cnt;
		price -= x * cnt;
		System.out.printf("coin=%d / total=%d / price=%d%n", x, totalCount, price);
	}
	
	private static double totalValue = 0;
	private static int capacity = 0;
	private static double getValue(Entry<Integer, Integer> entry) {
		return entry.getValue() / (double)entry.getKey();
	}
	private static void increase(Entry<Integer, Integer> entry) {
		int k = entry.getKey();
		int v = entry.getValue();
		
		if (capacity - k >= 0) {
			capacity -= k;
			totalValue += v;
			System.out.printf("[%s] / capacity=%d / total=%f / fraction=%d%n", entry, capacity, totalValue, 1);
		} else {
			double fraction = capacity / (double)k;
			capacity -= k * fraction;
			totalValue += v * fraction;
			System.out.printf("[%s] / capacity=%d / total=%f / fraction=%f%n", entry, capacity, totalValue, fraction);
			// XXX break in loop
		}
	}

	public static void main(String[] args) {
		
		/*
		 * 가장 적은 개수의 동전으로 지불하기
		 */
		price = 4720;
		int[] coins = new int[] {1, 100, 50, 500};
		// *.mapToInt(Integer::intValue).toArray()
		// 동전의 가치가 큰 순으로 정렬
		Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).forEach(Examples::increase);
		System.out.println(totalCount);
		
		/*
		 * 물건을 배낭에 넣기
		 * 무게와 가치로 표현되는 물건
		 * 물건은 쪼갤 수 있고 물건의 일부분을 배낭에 넣을 수 있음
		 */
		capacity = 30;
		Map<Integer, Integer> luggages = new HashMap<>();
		luggages.put(10, 10);
		luggages.put(15, 12);
		luggages.put(20, 10);
		luggages.put(25, 8);
		luggages.put(30, 5);
		
		// 가치/무게의 값이 높은 순으로 정렬
		luggages.entrySet().stream().sorted(Comparator.comparing(Examples::getValue, (x, y) -> y.compareTo(x))).forEach(Examples::increase);
		System.out.println(totalValue);
	}

}
