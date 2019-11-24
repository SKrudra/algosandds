package skrudra.alads;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5, 3, 7, 8, 6, 4 };
		int l = arr.length;
		int step = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l - i - 1; j++) {
				int temp = 0;
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					step++;
				}
			}
		}
		System.out.println(step);
		System.out.println(Arrays.toString(arr));
	}
}
