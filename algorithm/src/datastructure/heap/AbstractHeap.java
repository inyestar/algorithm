package datastructure.heap;

import java.util.Arrays;

public abstract class AbstractHeap<T> implements Heap<T> {

	protected Object[] arr;
	protected int size;
	protected static final int DEFAULT = 10;
	
	/*
	 * 자식 노드 // 2 = 부모 노드
	 * 부모노드 * 2 = 왼쪽 자식 노드
	 * 부모 노드 * 2 + 1 = 오른쪽 자식 노드
	 */
	protected abstract boolean moveUp(Node<T> current, Node<T> comparison);
	
	protected abstract boolean moveDown(Node<T> current, Node<T> comparison);
	
	protected abstract boolean leftOrRight(int left, int right);
	
	public void insert(T data) {
		
		if(size >= DEFAULT) {
			return;
		}
		
		Node<T> root = node(0);
		Node<T> newNode = newNode(key(data), data);
		int index = size;
		arr[size++] = newNode;
		if (root == null) {
			return;
		}
		
		Node<T> temp = null;
		Node<T> current = null;
		Node<T> parent = null;
		while(true) {
			int parentIdx = parent(index);
			current = node(index);
			parent = node(parentIdx);
			if(!moveUp(current, parent)) {
				break;
			}
			temp = parent;
			arr[parentIdx] = current;
			arr[index] = temp;
			index = parentIdx;
		}
	}
	
	public T pop() {
		if(size == 0) {
			return null;
		}
		
		if(size == 1) {
			
			Node<T> prevRoot = node(--size);
			arr[0] = null;
			return prevRoot.data;
		}
		
		final Node<T> prevRoot = node(0);
		arr[0] = node(--size);
		arr[size] = null;

		moveDown();
		return prevRoot.data;
	}
	
	private void moveDown() {
		
		if(size > 1) {
			
			int index = 0;
			Node<T> current = null;
			Node<T> comparison = null;
			Node<T> temp = null;
			while(true) {
				int leftIdx = left(index);
				int rightIdx = right(index);
				int comparisonIdx = -1;
				
				// 자식이 없을 때
				if(leftIdx >= size && rightIdx >= size) {
					break;
				}
				
				// 외쪽만 있을 때
				if(leftIdx < size && rightIdx >= size) {
					comparisonIdx = leftIdx;
				}
				
				if(leftIdx < size && rightIdx < size) {
					Node<T> left = node(leftIdx);
					Node<T> right = node(rightIdx);
					comparisonIdx = leftOrRight(left.getkey(), right.getkey()) ? leftIdx : rightIdx;
				}
				
				current = node(index);
				comparison = node(comparisonIdx);
				if(moveDown(current, comparison)) {
					temp = comparison;
					arr[comparisonIdx] = current;
					arr[index] = temp;
					index = comparisonIdx;
				} else {
					break;
				}
			}
		}
		
	}
	
	private Node<T> newNode(int key, T data) {
		return new Node<>(key, data);
	}
	
	private int parent(int index) {
		return ++index / 2 - 1;
	}
	
	private int left(int index) {
		return ++index * 2 - 1;
	}
	
	private int right(int index) {
		return ++index * 2;
	}
	
	@SuppressWarnings("unchecked")
	protected Node<T> node(int index) {
		if(index > size || index < 0) {
			return null;
		}
		return (Node<T>) arr[index];
	}
	
	private int key(Object data) {
		int h = data.hashCode();
		return (h ^ (h >> 16));
	}
	
	public String toString() {
		return Arrays.toString(arr);
	}
	
	static class Node<T> implements Heap.Node<T> {
			
		private int key;
		
		private T data;

		Node(int key, T data) {
			this.key = key;
			this.data = data;
		}
		
		@Override
		public int getkey() {
			return key;
		}

		@Override
		public T getValue() {
			return data;
		}
		
		public String toString() {
			return new StringBuilder()
					.append(data)
					.append("(")
					.append(key)
					.append(")")
					.toString();
		}
	}
}
