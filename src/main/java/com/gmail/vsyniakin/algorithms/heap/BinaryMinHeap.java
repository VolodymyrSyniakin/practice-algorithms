package com.gmail.vsyniakin.algorithms.heap;

public class BinaryMinHeap extends BinaryHeap {

	@Override
	public void build(int[] array) {
		for (int i = 0; i < array.length; i++) {
			this.heap.add(array[i]);
		}

		for (int i = this.heap.size() / 2 - 1; i >= 0; i--) {
			minHeapify(i);
		}

	}

	private void minHeapify(int i) {
		// check for any child elements
		if (i * 2 + 1 <= this.heap.size() - 1) {
			/*
			 * if element has two child then take max child, else @throws -
			 * IndexOutOfBoundsException
			 */
			try {
				if (this.heap.get(i * 2 + 1) < this.heap.get(i * 2 + 2)) {
					compareElements(i, i * 2 + 1);
				} else {
					compareElements(i, i * 2 + 2);
				}
			} catch (IndexOutOfBoundsException e) {
				compareElements(i, i * 2 + 1);
			}
		}
	}

	@Override
	protected void compareElements(int indexParent, int indexChild) {
		if (this.heap.get(indexParent) > this.heap.get(indexChild)) {
			swap(indexParent, indexChild);
			if (indexChild <= this.heap.size() / 2) {
				minHeapify(indexChild);
			}
		}
	}

	@Override
	protected void pushNumberToUp(int index) {
		while (index >= 0 && this.heap.get(index) < this.heap.get((index - 1) / 2)) {
			swap(index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	@Override
	public void add(Integer number) {
		this.heap.add(number);
		pushNumberToUp(this.heap.size() - 1);
	}

	@Override
	public void insert(int index, int number) {
		if (index < heap.size()) {
			this.heap.set(index, number);
			pushNumberToUp(index);
		}
	}

	@Override
	public int extract(int index) {
		int result = this.heap.get(index);
		this.heap.set(index, this.heap.remove(this.heap.size() - 1));
		minHeapify(index);
		return result;
	}

}
