package com.gmail.vsyniakin.algorithms.heap;

import java.util.ArrayList;

public abstract class BinaryHeap {
	protected ArrayList<Integer> heap = new ArrayList<Integer>();

	public abstract void add(Integer number);

	public abstract void build(int[] array);

	public abstract void insert(int index, int number);

	public abstract int extract(int index);

	public int getFirst() {
		return this.heap.get(0);
	}

	protected abstract void pushNumberToUp(int index);

	protected abstract void compareElements(int indexParent, int indexChild);

	protected void swap(int indexFirst, int indexSecond) {
		int temp = this.heap.get(indexFirst);
		this.heap.set(indexFirst, this.heap.get(indexSecond));
		this.heap.set(indexSecond, temp);
	}

	public ArrayList<Integer> getHeap() {
		return heap;
	}

	public void setHeap(ArrayList<Integer> heap) {
		this.heap = heap;
	}

}
