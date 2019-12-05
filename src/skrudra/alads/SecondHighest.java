package skrudra.alads;

public class SecondHighest {

	public static void main(String[] args) {
//		int[] ar = { 2, 3, 6, 6, 5 };
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int m = ar[0];
		int s = ar[1];
		if (ar[0] > ar[1]) {
			m = ar[0];
			s = ar[1];
		} else {
			m = ar[1];
			s = ar[0];
		}
		int t = Integer.MIN_VALUE;
		for (int i = 2; i < ar.length; i++) {
			t = ar[i];
			if (t > m) {
				s = m;
				m = t;
			} else if (t < m && t > s) {
				s = t;
			}
		}
		System.out.println(s);
	}
}
