package skrudra.alads;

public class CubeRoot {

	public static void main(String[] args) {
		int n = 9; //8;
		double cubeRoot = 0.0;

		double start = 0;
		double end = n;
		double precision = 0.000001;
		while (true) {
			double mid = (start + end) / 2;
			double diff = Math.abs(n - mid * mid * mid);
			if (diff <= precision) {
				cubeRoot = mid;
				break;
			}
			if (mid * mid * mid > n) {
				end = mid;
			} else {
				start = mid;
			}

		}
		System.out.println("Cuberoot of " + n + " is " + cubeRoot);
	}
}
