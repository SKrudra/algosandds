package skrudra.alads;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int l = arr.length;
		int h = arr[0].length;
		int sum = 0;
		for (int i = 0; i < l - 2; i++) {
			for (int j = 0; j < h - 2; j++) {
				int temp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (temp > sum) {
					sum = temp;
				}
			}
		}
		return sum;
	}

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long r = 0;
		int l = s.length();
		int a = l - s.replaceAll("a", "").length();

		int b = (int) (n % l);
		String str = s.substring(0, b);
		int p = str.length() - str.replaceAll("a", "").length();
		r = n / l * a;
		r += p;
		return r;
	}

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int j = 0;
		int i = 0;
		while (i < c.length - 2) {
			if (c[i + 2] == 0) {
				j++;
				i += 2;
			} else {
				j++;
				i++;
			}
		}
		return j + (c.length - i - 1);
	}

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int r = 0;
		int v = 0;
		boolean valleyStart = false;
		for (int i = 0; i < n; i++) {
			r += s.charAt(i) == 'U' ? 1 : -1;
			if (r < 0 && !valleyStart) {
				valleyStart = true;
			}
			if (r == 0 && valleyStart) {
				v++;
				valleyStart = false;
			}
		}
		return v;
	}

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(ar[0], 1);
		for (int i = 1; i < n; i++) {
			if (map.containsKey(ar[i])) {
				map.put(ar[i], map.get(ar[i]).intValue() + 1);
			} else {
				map.put(ar[i], 1);
			}
		}

		int r = 0;
		Integer[] ra = new Integer[map.values().size()];
		map.values().toArray(ra);
		for (int p = 0; p < ra.length; p++) {
			r = r + Integer.valueOf(ra[p].toString()) / 2;
		}

		return r;
	}

	public static void main(String[] args) throws IOException {
		int[] socks = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		System.out.println(sockMerchant(9, socks));
	}
}
