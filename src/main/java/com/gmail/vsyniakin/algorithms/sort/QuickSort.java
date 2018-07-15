package com.gmail.vsyniakin.algorithms.sort;

public class QuickSort {

	public static int[] sort(int[] array, int p, int r) {
		quickSort(array, p, r);
		return array;
	}

	private static void quickSort(int[] array, int p, int r) {
		int q;
		if (r > p) {
			q = partition(array, p, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
		}
	}

	private static int partition(int[] array, int p, int r) {
		int x = array[r];
		int i = p - 1;
		int temp;
		for (int j = p; j < r; j++) {
			if (array[j] <= x) {
				temp = array[++i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		temp = array[i + 1];
		array[i+1] = array[r];
		array[r] = temp;
		return ++i;
	}
}
