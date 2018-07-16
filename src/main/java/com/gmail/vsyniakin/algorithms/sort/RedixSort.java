package com.gmail.vsyniakin.algorithms.sort;

public class RedixSort {

	public static final char[] LETTERS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	// @param int[] numbers - values >= 0
	public static int[] sort(int[] numbers) {
		return redixSort(numbers, 1, getMaxRedix(numbers));
	}

	// @param String [] words - values = Latin symbols
	public static String[] sort(String[] words) {
		toLowerCase(words);
		return redixSort(words, 1, getMaxRedix(words));
	}

	private static int[] redixSort(int[] numbers, int redix, int maxRedix) {
		int[] countIndices = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			int index = getIndex(numbers[i], redix);
			++countIndices[index];
		}

		int[] positonElements = new int[10];
		positonElements[0] = countIndices[0];
		for (int i = 1; i < positonElements.length; i++) {
			positonElements[i] = countIndices[i] + positonElements[i - 1];

		}

		int[] result = new int[numbers.length];
		for (int i = numbers.length - 1; i >= 0; i--) {
			int index = getIndex(numbers[i], redix);
			result[--positonElements[index]] = numbers[i];
		}

		if (redix < maxRedix) {
			return redixSort(result, redix + 1, maxRedix);
		} else {
			return result;
		}
	}

	private static String[] redixSort(String[] words, int redix, int maxRedix) {
		// in element [0] - we count short words of maxRedix
		int[] countIndices = new int[LETTERS.length + 1];

		for (int i = 0; i < words.length; i++) {
			int index = getIndex(words[i], redix, maxRedix);
			if (index != -1) {
				++countIndices[index];
			}
		}

		int[] positonElements = new int[LETTERS.length + 1];
		positonElements[0] = countIndices[0];
		for (int i = 1; i < positonElements.length; i++) {
			positonElements[i] = countIndices[i] + positonElements[i - 1];

		}

		String[] result = new String[words.length];
		for (int i = words.length - 1; i >= 0; i--) {
			int index = getIndex(words[i], redix, maxRedix);
			if (index != -1) {
				result[--positonElements[index]] = words[i];
			}
		}
		if (redix < maxRedix) {
			return redixSort(result, redix + 1, maxRedix);
		} else {
			return result;
		}
	}

	private static String[] toLowerCase(String[] words) {
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
		}
		return words;
	}

	private static int getIndex(int number, int redix) {
		if (redix == 1) {
			return number % (int) Math.pow(10, redix);
		} else {
			return number % (int) Math.pow(10, redix) / (int) Math.pow(10, redix - 1);
		}
	}

	// @return - 0 if the word is shorter of the max length of [] words
	private static int getIndex(String word, int redix, int maxRedix) {
		if (word.length() + redix > maxRedix) {
			char letter = word.charAt(maxRedix - redix);
			for (int i = 0; i < LETTERS.length; i++) {
				if (letter == LETTERS[i]) {
					return i + 1;
				}
			}
		}
		return 0;
	}

	private static int getMaxRedix(int[] numbers) {
		int redix = 1;
		for (int i = 0; i < numbers.length; i++) {
			while ((numbers[i] / Math.pow(10, redix)) >= 1) {
				++redix;
			}
		}
		return redix;
	}

	private static int getMaxRedix(String[] words) {
		int redix = 1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > redix) {
				redix = words[i].length();
			}
		}
		return redix;
	}

}
