package skrudra.alads;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 5, 3, 7, 8, 6, 4 };
		System.out.println("Before: " + Arrays.toString(arr));
		int step = 0;
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while ((j > -1) && (arr[j] > key)) { // for reverse order (arr[j] < key)
				arr[j + 1] = arr[j]; // shift
				j--;
				step++;
			}
			arr[j + 1] = key; // insertion
			System.out.println("Step-" + i + ": " + Arrays.toString(arr));
		}
		System.out.println(step);
		System.out.println("After: " + Arrays.toString(arr));
	}

}
