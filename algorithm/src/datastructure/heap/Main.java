package datastructure.heap;

import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		Heap<String> maxHeap = new MaxHeap<>();
		IntStream.range(0, 11)
			.map(x -> x + 65)
			.forEach(x -> {
				maxHeap.insert(Character.toString((char) x));
			});
		System.out.println(maxHeap);
		IntStream.range(0, 11)
			.forEach(x -> {
				System.out.println(maxHeap.pop());
				System.out.println(maxHeap);
			});
		
		System.out.println("==============================");
		Heap<String> minHeap = new MinHeap<>();
		IntStream.range(0, 11)
		.map(x -> x + 65)
		.forEach(x -> {
			minHeap.insert(Character.toString((char) x));
		});
		System.out.println(minHeap);
		IntStream.range(0, 11)
		.forEach(x -> {
			System.out.println(minHeap.pop());
			System.out.println(minHeap);
		});
	}

}
