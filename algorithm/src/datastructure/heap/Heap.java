package datastructure.heap;

public interface Heap<T> {
	
	void insert(T data);
	
	T pop();
	
	interface Node<T> {
		
		int getkey();
		
		T getValue();
		
	}
}
