package algorithm.graph;

import java.util.List;
import java.util.Map;

public interface Graph {

	/*
	 * 그래프 : 노드간의 관계를 나타낸 것
	 * ㄴ 노드 : 최소 단위
	 * ㄴ 간선 : 관계를 나타낸 선
	 * ㄴ 트리 < 그래프
	 */
	void initialize(Map<String, List<String>> dict, String firstNode);
	
	List<String> execute();
}
