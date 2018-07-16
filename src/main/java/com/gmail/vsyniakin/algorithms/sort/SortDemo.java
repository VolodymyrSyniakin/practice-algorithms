package com.gmail.vsyniakin.algorithms.sort;

import java.util.Arrays;

import com.gmail.vsyniakin.algorithms.CreateRandomArray;

public class SortDemo {

	public static void main(String[] args) {
		int [] array = CreateRandomArray.getArrayNumbers(20, 1, 100);
		System.out.println(Arrays.toString(array));
		
		// Merge sort:
		
//		System.out.println(Arrays.toString(MergeSort.sort(array)));

		
		// Quick sort:

//		System.out.println(Arrays.toString(QuickSort.sort(array, 0, array.length-1)));

		
		// Counting sort:
		
//		System.out.println(Arrays.toString(CountingSort.counting(array, 110)));
		
		// Redix sort:
		
		System.out.println(Arrays.toString(RedixSort.sort(array)));

	}

}
