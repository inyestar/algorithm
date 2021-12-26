package datastructure.tree;

import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(77);
//		new Random().ints(10, 1, 100).forEach(x -> {
//			bst.insert(x);
//		});
		IntStream.of(6, 17, 39, 40, 49, 56, 61, 61, 62, 67, 96)
			.forEach(x -> {
				bst.insert(x);
			});
		bst.insert(17);
		bst.traverseInOrder();
		bst.delete(77);
		bst.traverseInOrder();
		
	}

}
