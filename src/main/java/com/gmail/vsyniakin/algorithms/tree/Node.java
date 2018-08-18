package com.gmail.vsyniakin.algorithms.tree;

public abstract class Node {
	protected int key;
	protected int value;

	protected Node parent;
	protected Node left;
	protected Node right;

	protected Node() {
		super();
	}

	protected Node(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}

	protected Node(int key, int value, Node parent) {
		super();
		this.key = key;
		this.value = value;
		this.parent = parent;
	}

	protected abstract void insert(int key, int value);

	protected abstract void remove();

	protected abstract Node search(int key);

	protected abstract Node min();

	protected abstract Node max();

	protected abstract Node successor(Node node);

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("key=").append(key).append(", value=").append(value).append("; ");
		
		if (this.left != null) {
			result.append(this.left.toString());
		}
		if (this.right != null) {
			result.append(this.right.toString());
		}
		return result.toString();
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	
	
}
