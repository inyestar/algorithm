package algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch implements Graph{

	/**
	 * 같은 레벨의 자식들을 먼저 탐색하는 방법
	 * ㄴ key : 노드
	 * ㄴ value : 인접한 노드들(array)
	 * 1) node가 visitedQueue에 없으면 visitedQueue에 in, node의 값들을 needVisit에 in
	 * 2) needVisit의 가장 맨 처음의 node가 visitedQueue에 있으면 다음 node로 이동
	 * ㄴ O(V+E) : 노드 + 간선의 수
	 */
	
	private Map<String, List<String>> dict;
	
	private String firstNode;
	
	private List<String> visitedQueue = new ArrayList<>();
	
	private List<String> needVisitQueue = new ArrayList<>();
	
	public BreadthFirstSearch(Map<String, List<String>> dict, String firstNode) {
		this.dict = dict;
		this.firstNode = firstNode;
	}
	
	@Override
	public void doExecute() {
		
		// firstNode를 visitedQueue에 넣어줌
		visitedQueue.add(firstNode);
		needVisitQueue.addAll(dict.get(firstNode));
		
		// needVisitQueue 크기 만큼 반복
		while(!needVisitQueue.isEmpty()) {
			String node = needVisitQueue.get(0);
			// node가 visitedQueue에 없으면 node와 값을 추가
			if(!visitedQueue.contains(node)) {
				visitedQueue.add(node);
				needVisitQueue.addAll(dict.get(node));
			} 
			
			// node가 vistedQueue에 있건 없건 pop의 의미로 제거
			needVisitQueue.remove(0);
		}
		
		System.out.println(visitedQueue);
	}
	
}
