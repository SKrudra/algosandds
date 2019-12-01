package skrudra.alads;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	// Complete the isValid function below.
	static String isValid(String s) {
		Map<Character, Integer> deck = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (deck.containsKey(s.charAt(i))) {
				deck.put(s.charAt(i), deck.get(s.charAt(i)).intValue() + 1);
			} else {
				deck.put(s.charAt(i), 1);
			}
		}
		System.out.println(deck.values());
        Integer[] values = new Integer[deck.values().size()];
        values = deck.values().toArray(values);
        int first = Collections.min(Arrays.asList(values));
        System.out.println(first);
        int exception = 0;
        for (int j = 0; j < values.length; j++) {
            if (exception > 1) {
                return "NO";
            } else if (exception == 0) {
                exception++;
            }
        }
        return "YES";
	}

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {
		// check for the number of occurrences
		String repeated = "";
		int r = 0;
		for (int i = 1; i <= a.length(); i++) {
			String test = a.substring(i - 1, i);
			if (!b.contains(test)) {
				r++;
			} else if (!repeated.contains(test)) { // skip the repeated numbers
				repeated += test;
				int first = b.length() - b.replaceAll(test, "").length();
				int second = a.length() - a.replaceAll(test, "").length();
				r += first > second ? first - second : second - first;
			}
		}
		for (int j = 1; j <= b.length(); j++) {
			if (!a.contains(b.substring(j - 1, j))) {
				r++;
			}

		}
		return r;
	}

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int swap = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != i - 1 + 1) {
				int temp = arr[i];
//                map.get(i) // check against the index and swap
			}
		}
		return swap;
	}

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) { // 1 2 5 3 7 8 6 4
		int steps = 0;
		for (int i = 0; i < q.length; i++) {
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
		}
		for (int i = 1; i < q.length; i++) {
			int j = i - 1;
			int key = q[i];
			while ((j > -1) && (q[j] > key)) {
				q[j + 1] = q[j];
				j--;
				steps++;
			}
			q[j + 1] = key; // insertion
		}
		System.out.println(steps);
	}

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {
		int[] r = new int[a.length];
		int l = a.length;
		int index = l - d % l - 1;
		int t1 = index;
		r[index] = a[l - 1];
		int temp = l - 1;
		for (int i = index; i >= 0; i--) {
			r[index--] = a[temp--];
		}
		for (int j = t1 + 1, k = 0; j < l; j++, k++) {
			r[j] = a[k];
		}
		return r;
	}

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int l = arr.length;
		int h = arr[0].length;
		int sum = Integer.MIN_VALUE;
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

		System.out.println(makeAnagram("fcrxzwscanmligyxyvym`", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
	}
}
