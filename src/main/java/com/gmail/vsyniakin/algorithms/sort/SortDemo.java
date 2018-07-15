package com.gmail.vsyniakin.algorithms.sort;

import java.util.Arrays;

public class SortDemo {

	public static void main(String[] args) {
		int [] array = new int[] {2, 7, 3, 1, 4, 7, 3, 6, 2};
		
		// Merge sort:
		
//		System.out.println(Arrays.toString(MergeSort.sort(array)));

		
		// Quick sort:

//		System.out.println(Arrays.toString(QuickSort.sort(array, 0, array.length-1)));

		
		// Counting sort:
		
		System.out.println(Arrays.toString(CountingSort.counting(array, 7)));
	}

}
