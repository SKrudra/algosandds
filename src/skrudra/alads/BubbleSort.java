package skrudra.alads;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 8, 3, 5, 9, 2, 4, 8 };
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l - i - 1; j++) {
				int temp = 0;
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
