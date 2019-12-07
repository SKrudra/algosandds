package skrudra.alads;

public class SquareRoot {

	public static void main(String[] args) {
		int number = 6; // 5
		double squareRoot = number / 2;
		double t;
		System.out.println(Math.sqrt(number));
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);

		System.out.println(squareRoot);

	}
}
