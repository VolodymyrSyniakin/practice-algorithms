package com.gmail.vsyniakin.algorithms.sort;

public class CountingSort {
	public static int [] counting (int array [], int maxVal) {
		int [] indeсes = new int [maxVal];
		
		for (int i = 0; i < array.length; i++) {
			++indeсes[array[i]-1]; 
		}
		int position = 0;
		
		for (int i = 0; i < indeсes.length; i++) {
			for (int j = 0; j < indeсes[i]; j++) {
				array[position++] = i+1;
			}
		}
		
		return array;
	}
}
