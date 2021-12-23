package datastructure.hash;

import java.util.Arrays;

public class HashMap<K, V> {
	
	private Node<K, V>[] table;
	private int SIZE = 10;
	
	public HashMap() {
		table =	(Node<K,V>[]) new Node[SIZE];
	}
	
	public void put(K key, V value) {
		if(key == null) {
			throw new Error("Null cannot be applied to Key");
		}
		int hash = hash(key);
		// 왜 이렇게 index를 구하는거지?
		int index = index(hash);
		Node<K, V> tenant = table[index];
		Node<K, V> newNode = newNode(hash, key, value, null);
		if (tenant == null) {
			table[index] = newNode;
		} else {
			tenant.next = newNode;
		}
	}
	
	public V get(Object key) {
		Node<K, V> node = getNode(key);
		return node == null ? null : node.value;
	}
	
	private Node<K, V> getNode(Object key) {
		int hash = hash(key);
		Node<K, V> node = table[index(hash)];
		if (node == null) {
			return null;
		}
		if (node.hash == hash && (key == node.key || key.equals(node.key))) {
			return node;
		}
		Node<K, V> next = node.next;
		if(next != null) {
			do {
				if (next.hash == hash && (key == next.key || key.equals(next.key))) {
					return next;
				}
			} while ((next = next.next) != null);
		}
		
		return null;
	}
	
	private int index(int hash) {
		return  SIZE - 1 & hash;
	}
	
	private Node<K, V> newNode(int hash, K key, V value, Node<K,V> next) {
		return new Node<>(hash, key, value, next);
	}
	
	private int hash(Object key) {
		int h = key.hashCode();
		// 원래 hashcode랑 2 byte 나 줄인 값이랑 XOR을 하면 뭐가 좋은 거지?
		return h ^ (h >>> 16); 
	}
	
	public String toString() {
		return Arrays.toString(table);
	}

	static class Node<K, V> {
		final int hash;
		final K key;
		V value;
		Node<K, V> next;
		
		Node(int hash, K key, V value, Node<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public String toSring() {
			return new StringBuilder()
					.append(key)
					.append("=")
					.append(value)
					.toString();
		}
	}
}
