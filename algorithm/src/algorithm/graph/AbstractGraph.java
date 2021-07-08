package algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractGraph implements Graph{
	
	private Map<String, List<String>> dict;
	private List<String> visitedQueue = new ArrayList<>();
	private List<String> needVisitQueueOrStack = new ArrayList<>();
	
	@Override
	public void initialize(Map<String, List<String>> dict, String firstNode) {
		
		this.dict = dict;
		visitedQueue.add(firstNode);
		needVisitQueueOrStack.addAll(dict.get(firstNode));
	}
	
	@Override
	public List<String> execute() {
		
		while(!needVisitQueueOrStack.isEmpty()) {
			
			int idx = getIndex();
			String node = needVisitQueueOrStack.get(idx);
			if(!visitedQueue.contains(node)) {
				visitedQueue.add(node);
				needVisitQueueOrStack.addAll(dict.get(node));
			}
			
			needVisitQueueOrStack.remove(idx);
		}
		
		return visitedQueue;
	}
	
	public abstract int getIndex();
	
	public int getSizeOfNeedVisit() {
		return needVisitQueueOrStack.size();
	}
}
