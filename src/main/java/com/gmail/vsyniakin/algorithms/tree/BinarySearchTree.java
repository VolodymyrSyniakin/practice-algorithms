package com.gmail.vsyniakin.algorithms.tree;

public class BinarySearchTree implements Tree {

	private Node root;

	public BinarySearchTree() {
		super();
	}

	@Override
	public void insert(int key, int value) {
		if (root == null) {
			root = new NodeSearchTree(key, value);
		} else {
			root.insert(key, value);
		}
	}

	@Override
	public void remove(int key) {
		Node rm = root.search(key);
		rm.remove();
	}

	@Override
	public int getValue(int key) {
		return root.search(key).value;
	}

	@Override
	public String toString() {
		return "BinarySearchTree: [" + root.toString() + "]";
	}

	public Node getRoot() {
		return root;
	}
}
