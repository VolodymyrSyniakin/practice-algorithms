package com.gmail.vsyniakin.algorithms;



public class CreateRandomArray {
	public static int[]  getArrayNumbers (int size, int min, int max) {
		int [] array = new int[size]; 
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * (max - min + 1) + min); 
		}
		return array;
		
	}
}
