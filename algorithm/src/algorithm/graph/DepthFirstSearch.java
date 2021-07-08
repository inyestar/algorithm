package algorithm.graph;

public class DepthFirstSearch extends AbstractGraph{

	@Override
	public int getIndex() {
		return getSizeOfNeedVisit() - 1;
	}
	

	/**
	 * 자식 노드부터 다 순회 후 같은 레벨로 이동
	 * ㄴ key : 노드
	 * ㄴ value : 인접한 노드들(array)
	 * 1) node가 visitedQueue에 없으면 visitedQueue에 in, node의 값들을 needVisit에 in
	 * 2) needVisit의 가장 마지막의 node가 visitedQueue에 있으면 다음 node로 이동
	 * ㄴ O(V+E) : 노드 + 간선의 수
	 */


}
