package com.gmail.vsyniakin.algorithms.tree;

public class DemoTree {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(17, 17);
		tree.insert(7, 7);
		tree.insert(37, 37);
		tree.insert(24, 24);
		tree.insert(12, 12);
		tree.insert(14, 14);
		tree.insert(3, 3);
		tree.insert(8, 8);
		tree.insert(10, 10);
		tree.insert(1, 1);
		
		tree.remove(7);	
		System.out.println(tree.toString());

	}

}
