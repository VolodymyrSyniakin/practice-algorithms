package com.gmail.vsyniakin.algorithms.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] sort(int[] array) {
		if (array.length > 1) {
			return split (array);
		} 
		return array;
	}
	
	private static int[] split (int [] array) {
		int middle = array.length / 2;
		return mergeSort(Arrays.copyOfRange(array, 0, middle), Arrays.copyOfRange(array, middle, array.length));
	}

	private static int[] mergeSort(int[] a, int[] b) {
		a = sort(a);
		b = sort(b);
		
		int[] sortArrray = new int[a.length + b.length];
		int ai = 0;
		int bi = 0;

		for (int i = 0; i < sortArrray.length; i++) {
			if (ai >= a.length) {
				sortArrray[i] = b[bi++];
				continue;
			}
			if (bi >= b.length) {
				sortArrray[i] = a[ai++];
				continue;
			}
			if (a[ai] <= b[bi]) {
				sortArrray[i] = a[ai++];
			} else {
				sortArrray[i] = b[bi++];
			}
		}
		return sortArrray;
	}

}
