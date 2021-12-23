package datastructure.list;

public class LinkedList<E> {
	
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public void add(E e) {
		final Node<E> prev = last;
		final Node<E> newNode = new Node<>(prev, e, null);
		last = newNode;
		
		// 처음인 경우
		if(prev == null) {
			first = newNode;
		} else {
			prev.next = newNode;
		}
		size++;
	}
	
	public E get(int index) {
		
		return node(index).data;
	}
	
	public void remove(int index) {
		
		unlink(node(index));
	}
	
	public void remove(E e) {
		for(Node<E> node = first; node != null; node = node.next) {
			if(e.equals(node.data)) {
				unlink(node);
				break;
			}
		}
	}
	
	private void unlink(Node<E> node) {
		/*
		 * # 로컬 변수에 final 선언 시 
		 * primitive : 한 번 초기화되면 바꿀 수 없는 상수가 됨
		 * reference : 한 번 할당된 '참조'를 바꿀 수 없음 but 속성 변경 가능
		 * 
		 * # 메서드 인자에 final 선언 시
		 * 메서드 안에서 변수값 변경 불가능
		 * 
		 * # 멤버 변수에 final 선언 시
		 * 상수값이 되거나 write-once 필드로 한 번만 쓰이게 됨
		 * static일 경우 : 값과 함께 선언할 때 초기화, static {} 에서 초기화
		 * non-static : 값과 함께 선언할 때 초기화, 인스턴스 초기화 블록에서, 생성자 메서드에서
		 * 
		 */
		final Node<E> prev = node.prev;
		final Node<E> next = node.next;
		
		if(prev == null) {
			// 첫 번째 노드
			first = next;
		} else {
			// 첫 번째가 아닌 모든 노드
			// next가 null이면 null이 들어가겠지
			prev.next = next;
			node.prev = null;
		}
		
		if (next == null) {
			// 마지막 노드
			last = prev;
		} else {
			// 마지막이 아닌 모든 노드
			next.prev = prev;
			node.next = null;
		}
		
		node.data = null;
		size--;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node<E> node = first;
		int cnt = 0;
		builder.append("[");
		while(node.hasNext()) {
			builder.append(node);
			if(cnt++ < size) {
				builder.append(", ");
			}
			node = node.next;
		}
		builder.append(last);
		builder.append("]");
		return builder.toString();
	}
	
	private Node<E> node(int index) {
		
		int mid = size / 2;
		if (index <= mid) {
			Node<E> node = first;
			for(int i=0; i<index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for(int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	
	static class Node<E> {
		
		E data;
		Node<E> next;
		Node<E> prev;
		
		Node(Node<E> prev, E data, Node<E> next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
		
		boolean hasNext() {
			return next != null;
		}
		
		public String toString() {
			return String.valueOf(data);
		}
	}
}
