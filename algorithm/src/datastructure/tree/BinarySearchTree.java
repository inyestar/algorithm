package datastructure.tree;

public class BinarySearchTree<T extends Number & Comparable<T>> {
	
	private Node<T> root;
	
	public void insert(T data) {
		
		Node<T> newNode = newNode(data, null, null);;
		if(root == null) {
			root = newNode;
			return;
		}
		
		Node<T> prev = null;
		Node<T> parent = root;
		while(parent != null) {
			prev = parent;
			parent = parent.compareTo(data) > 0 ? parent.left : parent.right;
		}
		
		if (prev.compareTo(data) > 0) {
			prev.left = newNode;
		} else {
			prev.right = newNode;
		}
		
	}
	
	public boolean search(T data) {
		Node<T> current = root;
		while(current != null) {
			if(current.data.equals(data)) {
				return true;
			}
			current = current.compareTo(data) > 0 
					? current.left 
					: current.right;
		}
		return false;
	}
	
	// TODO 리팩토링 필요
	public void delete(T data) {
		
		Node<T> parent = root;
		Node<T> current = root;
		boolean found = false;
		while(current != null) {
			if(current.data.equals(data)) {
				found = true;
				break;
			}
			parent = current;
			current = current.compareTo(data) > 0 
					? current.left 
					: current.right;
		}
		
		if(!found) {
			return;
		}
		
		Node<T> child = null;
		if(current.left != null && current.right == null) {
			child = current.left;
		}
		
		if(current.left == null && current.right != null) {
			child = current.right;
		}
		
		if(current.left != null && current.right != null) {
			
			Node<T> prev = current;
			child = current.right;
			while(child.left != null) {
				prev = child;
				child = child.left;
			}
			
			if(current == root) {
				child.left = current.left;
			} else {
				child.left = current.left;
				child.right = current.right;
			}
			prev.left = child.right == null ? null : child.right;
		}
		
		if(parent.compareTo(current.data) > 0) {
			parent.left = child;
		} else {
			parent.right = child;
		}
		
		if(parent == current) {
			root = child;
		}
		
		current.left = null;
		current.right = null;
	}
	
	public void traversePreOrder() {
		traversePreOrder(root);
		System.out.println();
	}
	
	public void traverseInOrder() {
		traverseInOrder(root);
		System.out.println();
	}
	
	public void traversePostOrder() {
		traversePostOrder(root);
		System.out.println();
	}
	
	// level이 낮은 것부터 출력
	private void traversePreOrder(Node<T> root) {
		if(root == null) {
			return;
		}
		// root left right
		System.out.print(root + " ");
		traversePreOrder(root.left);
		traversePreOrder(root.right);
	}
	
	// 오름 차순
	private void traverseInOrder(Node<T> root) {
		if(root == null) {
			return;
		}
		
		// left root right
		traverseInOrder(root.left);
		System.out.print(root + " ");
		traverseInOrder(root.right);
	}
	
	// level이 높은 것부터 출력
	private void traversePostOrder(Node<T> root) {
		if(root == null) {
			return;
		}
		
		// left right root
		traversePostOrder(root.left);
		traversePostOrder(root.right);
		System.out.print(root + " ");
	}
	
	private Node<T> newNode(T data, Node<T> left, Node<T> right) {
		return new Node<>(data, left, right);
	}
	
	static class Node<T extends Number & Comparable<T>> implements Comparable<T> {

		// 데이터를 number 받을게 아니라 key랑 구분했어야 함 키를 가지고 비교햇어야함.. value랑 연관 있는
		T data;
		Node<T> left;
		Node<T> right;
		
		Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return String.valueOf(data);
		}

		@Override
		// 헷갈리게 만든거 같은데
		public int compareTo(T o) {
			// this가 크면 1
			// this랑 같으면 0
			// this가 작으면 -1
			return this.data.compareTo(o);
		}
	}
}
