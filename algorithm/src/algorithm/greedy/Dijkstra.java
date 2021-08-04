package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {
	
	private List<Dijkstra.Node> dijkstra;
	private List<Dijkstra.Node> priorityQueue;
	
	public Dijkstra(String ...nodes) {
		
		dijkstra = new ArrayList<>(nodes.length);
		priorityQueue = new ArrayList<>();
		Arrays.stream(nodes).forEach(x -> {
			Node n = new Node(x, Integer.MAX_VALUE);
			dijkstra.add(n);
		});
	}
	
	public static void main(String[] args) {
		
		// 거리를 담을 배열과 우선순위 큐 초기화
		Dijkstra instance = new Dijkstra("A", "B", "C", "D", "E", "F");
		
		// 첫 번째 노드의 자기 자신과의 거리
		Node first = instance.new Node("A", 0);
		instance.dijkstra.add(first);
		instance.priorityQueue.add(first);
		
		// todo
		
	}

	private class Node {
		private String name;
		
		private int distance;
		
		public Node(String name, int distance) {
			this.name = name;
			this.distance = distance;
		}

		public String getName() {
			return name;
		}

		public int getDistance() {
			return distance;
		}

		
		
	}
	
}
