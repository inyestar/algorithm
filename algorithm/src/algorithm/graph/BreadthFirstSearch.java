package algorithm.graph;

public class BreadthFirstSearch extends AbstractGraph{

	@Override
	public int getIndex() {
		return 0;
	}
	
	/**
	 * 같은 레벨의 자식들을 먼저 탐색하는 방법
	 * ㄴ key : 노드
	 * ㄴ value : 인접한 노드들(array)
	 * 1) node가 visitedQueue에 없으면 visitedQueue에 in, node의 값들을 needVisit에 in
	 * 2) needVisit의 가장 맨 처음의 node가 visitedQueue에 있으면 다음 node로 이동
	 * ㄴ O(V+E) : 노드 + 간선의 수
	 */

	
}
