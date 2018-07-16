package com.gmail.vsyniakin.algorithms.sort;

/* @param int array[] - values > 0
 * @param int maxVal >= max value in @param int array[]
 * */
public class CountingSort {
	public static int[] counting(int array[], int maxVal) {

		int[] indiсes = new int[maxVal];
		for (int i = 0; i < array.length; i++) {
			++indiсes[array[i] - 1];
		}

		int[] positionElements = new int[maxVal];
		positionElements[0] = indiсes[0];
		for (int i = 1; i < positionElements.length; i++) {
			positionElements[i] = indiсes[i] + positionElements[i - 1];
		}

		int[] result = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			result[--positionElements[array[i]-1]] = array[i];
		}
		
		return result;
	}
}
