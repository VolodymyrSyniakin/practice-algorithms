package com.gmail.vsyniakin.algorithms.tree;

public class NodeSearchTree extends Node {
	
	public NodeSearchTree() {
		super();
	}

	public NodeSearchTree(int key, int value, Node parent) {
		super(key, value, parent);
	}

	public NodeSearchTree(int key, int value) {
		super(key, value);
	}

	@Override
	protected void insert(int key, int value) {
		if (key <= this.key) {
			if (this.left == null) {
				this.left = new NodeSearchTree (key, value);
				this.left.parent = this;
			} else {
				this.left.insert(key, value);
			}
		} else if (key > this.key) {
			if (this.right == null) {
				this.right = new NodeSearchTree (key, value);
				this.right.parent = this;
			} else {
				this.right.insert(key, value);
			}
		}

	}

	@Override
	protected void remove() {
		if (this.left == null && this.right == null) {
			if (this.parent != null) {
				if (this.equals(this.parent.left)) {
					this.parent.left = null;
				} else {
					this.parent.right = null;
				}
			}
		} else if (this.right == null) {
			if (this.equals(this.parent.left)) {
				this.parent.left = this.left;
			} else {
				this.parent.right = this.left;
			}
			this.left.parent = this.parent;
			
		} else if (this.left == null) {
			if (this.equals(this.parent.left)) {
				this.parent.left = this.right;
			} else {
				this.parent.right = this.right;
			}
			this.right.parent = this.parent;
			
		} else {
			Node successor = successor(this);
			if (successor.parent.equals(this)) {
				successor.parent = this.parent;
				if (this.parent.left != null && this.parent.left.equals(this)) {
					this.parent.left = successor;
				} else {
					this.parent.right = successor;
				}
				
				successor.left = this.left;
				this.left.parent = successor;
			} else {
				if (successor.right != null) {
					successor.right.parent = successor.parent;
					successor.parent.left = successor.right;
				} else {
					successor.parent.left = null;
				}
				this.key = successor.key;
				this.value = successor.value;
			}
		}
	}
	
	@Override
	protected Node search(int key) {
		if (key == this.key) {
			return this;
		} else if (key < this.key) {
			if (this.left != null) {
				return this.left.search(key);
			}
		} else if (key > this.key) {
			if (this.right != null) {
				return this.right.search(key);
			}
		}
		return null;
	}
	
	@Override
	protected Node min() {
		if (this.left != null) {
			return this.left.min();
		} else {
			return this;
		}
	}
	
	@Override
	protected Node max() {
		if (this.right != null) {
			return this.right.min();
		} else {
			return this;
		}
	}
	
	@Override
	protected Node successor (Node node) {
		if (node.right != null) {
			return node.right.min();
		}
		Node nodeParent = node.parent; 
		while (nodeParent != null && node.equals(nodeParent.right)) {
			node = nodeParent;
			nodeParent = nodeParent.parent;
		}
		return node;
	}
	
	
}
