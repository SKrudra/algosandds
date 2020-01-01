package skrudra.alads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;

public class Solution {

	// Complete the migratoryBirds function below.
	static int migratoryBirds(List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {

			if (map.containsKey(arr.get(i))) {
				map.put(arr.get(i), map.get(arr.get(i)) + 1);
			} else {
				map.put(arr.get(i), 1);
			}
		}
		return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), Collections.max(map.values())))
				.map(Map.Entry::getKey).findFirst().get();
	}

	// sum of digits using recursion
	public static int sumOfDigitsWithRecursion(int n) {
		int sum = 0;
		if (n == 0) {
			return sum;
		}
		sum = n % 10 + sumOfDigitsWithRecursion(n / 10);
		return sum;
	}

	// Complete the whatFlavors function below.
	static void whatFlavors(int[] cost, int money) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < cost.length; i++) {
			int sunny = money - cost[i];
			if (map.containsKey(sunny)) {
				int a = i + 1;
				int b = map.get(sunny);
				System.out.println((a > b ? b : a) + " " + (a > b ? a : b));
				return;
			} else {
				map.put(cost[i], i + 1);
			}
		}
	}

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {
		int ex = 0;
		for (int i = d - 1; i < expenditure.length - 1; i++) {

			int arr[] = new int[d];
			for (int j = 0; j < d; j++) {
				arr[j] = expenditure[i - j];
			}

			Arrays.sort(arr);

			float median = 0;
			if (d % 2 == 0) {
				median = (arr[d / 2] + arr[(d / 2) + 1]) / 2;
			} else {
				median = arr[d / 2];
			}

			if (expenditure[i + 1] >= (median * 2)) {
				ex++;
			}
		}
		return ex;
	}

	// Complete the maximumToys function below.
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);
		int sum = 0;
		int index = 0;
		for (int i = 0; i < prices.length; i++) {
			sum += prices[i];
			index = i;
			if (sum > k) {
				break;
			}
		}

		return index;
	}

	// Complete the circularArrayRotation(right shift) function below.
	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int n = a.length;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[(i + k) % n] = a[i];
		}
		int[] output = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			output[i] = arr[queries[i]];
		}
		return output;
	}

	// Complete the birthdayCakeCandles function below.
	static int birthdayCakeCandles(int[] ar) {
		int max = 0;
		OptionalInt i = Arrays.stream(ar).max();
		if (i.isPresent()) {
			max = i.getAsInt();
		}
		final int temp = max;
		return (int) Arrays.stream(ar).filter(a -> a == temp).count();
	}

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		long min = 0;
		long max = 0;

		for (int i = 0; i < arr.length; i++) {
			long temp = 0;
			for (int j = 0; j < 5; j++) {
				if (i != j) {
					temp += arr[j];
				}
			}
			if (i == 0) {
				min = temp;
				max = temp;
			} else {
				if (temp < min) {
					min = temp;
				} else if (temp > max) {
					max = temp;
				}
			}
		}
		System.out.println(min + " " + max);
	}

	// Complete the substrCount function below.
	static long substrCount(int n, String str) {
		long r = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i < j) {
					String t = str.substring(i, j);
					System.out.println(t);
					StringBuilder sb = new StringBuilder(t).reverse();
					System.out.println(sb);
//					if(t.substring(0, t.length()/2).equals(t.length() - t.length()/2))
					if (t.equals(sb.toString())) {
						// check for same beginning and ending
						int p = 0;
						for (int k = 0; t.length() > 1 && k < t.length(); k++) {
							if (t.charAt(k) != t.charAt(k + 1)) {
								p = k;
								break;
							}
						}
						if (p == 0) {
							r++;
						} else if (p <= t.length() && t.startsWith(t.substring(p))) {
							r++;
						}
					}
				}
			}
		}
		return r;
	}

	static int maxSequenceOf1sInBinary(int n) {
		// int n = 439;
		String binary = "";
		while (n > 0) {
			binary = n % 2 + binary;
			n /= 2;
		}
		System.out.println(binary);
		int max = 1;
		int temp = 1;
		for (int i = 0; i < binary.length() - 1; i++) {
			if ("1".equals(binary.substring(i, i + 1)) && "1".equals(binary.substring(i + 1, i + 2))) {
				temp++;
			} else if (temp > max) {
				max = temp;
				temp = 1;
			} else {
				temp = 1;
			}
		}
		System.out.println(max > temp ? max : temp);
		return max > temp ? max : temp;
	}

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<>(2);
		int f = 0;
		int l = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i)) {
				f = result.get(0);
				result.add(0, f + 1);
			} else {
				l = result.get(1);
				result.add(1, l + 1);
			}
		}
		result.add(0, f);
		result.add(1, l);
		return result;
	}

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
		// System.out.println(sockMerchant(9, socks));

		// System.out.println(makeAnagram("fcrxzwscanmligyxyvym`",
		// "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));

//		System.out.println(substrCount(7, "abcbaba"));

//		miniMaxSum(new int[]{793810624, 895642170, 685903712, 623789054, 468592370});

	}
}


