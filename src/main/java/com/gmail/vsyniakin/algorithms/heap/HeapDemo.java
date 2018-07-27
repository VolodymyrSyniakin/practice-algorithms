package com.gmail.vsyniakin.algorithms.heap;

import java.util.Arrays;

public class HeapDemo {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		BinaryHeap hLow = new BinaryMaxHeap();
		BinaryHeap hHight = new BinaryMinHeap();

		hLow.build(array);
		hHight.build(array);

		System.out.println(Arrays.toString(hLow.getHeap().toArray()));
		System.out.println(Arrays.toString(hHight.getHeap().toArray()));
	}
}
