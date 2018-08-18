package com.gmail.vsyniakin.algorithms.tree;

public interface Tree {
	void insert (int key, int value);
	void remove (int key);
	int getValue (int key);
}
