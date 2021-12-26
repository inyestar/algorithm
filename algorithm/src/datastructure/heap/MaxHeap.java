package datastructure.heap;

public class MaxHeap<T> extends AbstractHeap<T> {
	
	public MaxHeap() {
		arr = new Object[DEFAULT];
	}

	@Override
	public boolean moveUp(Node<T> current, Node<T> comparison) {
		if(current == null || comparison == null) {
			return false;
		}
		return current.getkey() > comparison.getkey();
	}
	
	@Override
	protected boolean moveDown(Node<T> current, Node<T> comparison) {
		if(current == null || comparison == null) {
			return false;
		}
		return current.getkey() < comparison.getkey();
	}

	@Override
	protected boolean leftOrRight(int left, int right) {
		return left > right;
	}
	
	

}
