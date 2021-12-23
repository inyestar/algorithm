package algorithm.greedy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Backpack {

	public static void main(String[] args) {
		int k = 30;
		int[] w = new int[] {10, 15, 20, 25, 30};
		int[] v = new int[] {10, 12, 10, 8, 5};
		
		List<Item> items = IntStream.range(0, w.length)
				.mapToObj(i -> new Item(w[i], v[i]))
				.collect(Collectors.toList());
		
		Collections.sort(items, Item::compare);
		double sumValue = 0;
		for(Item item : items) {
			// 현재 item을 다 채울 수 있을 만큼 용량이 남아있음
			if(k - item.getValue() >= 0) {
				sumValue += item.getValue();
				k -= item.getWeight();
			} 
			// 현재 item을 다 채울수가 없어서 쪼개서 넣어야함
			else {
//				int fraction = k;
//				sumValue += item.divideValueByWeight() * fraction;
//				k -= fraction;
				double fraction = k * 1.0 / item.getWeight();
				sumValue += item.getValue() * fraction;
				k -= item.getWeight() * fraction;
			}
			
			if(k == 0) {
				break;
			}
		}
		
		System.out.println(sumValue);
	}

	
	private static class Item {
		private int weight;
		private int value;
		
		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public int getValue() {
			return value;
		}
		
		public double divideValueByWeight() {
			return value * 1.0 / weight;
		}
		
		public int compare(Item i2) {
			double v1 = divideValueByWeight();
			double v2 = i2.divideValueByWeight();
			
			return Double.compare(v2, v1);
		}
		
		public String toString() {
			return "(" + weight + "," + value + ")";
		}
	}
}
