package console.input;

import java.util.Scanner;

/**
 * This class shows a way to read console input with mixed types e.i. numbers,
 * strings in any order and avoiding
 * <strong>java.util.InputMismatchException</strong>
 * 
 * @author Sandeep.Kumar
 *
 */
public class ConsoleInputScanner {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println(x);
		double y = sc.nextDouble();
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println(y);
		char z = sc.next().charAt(0);
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println(z);
		String hello = sc.nextLine();
		System.out.println(hello);
		float tt = sc.nextFloat();
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println(tt);
	}
}