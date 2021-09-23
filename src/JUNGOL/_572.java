package JUNGOL;

import java.util.Scanner;

public class _572 {

	public static double area(double r) {
		double result = r * r * 3.14;
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		sc.close();

		System.out.printf("%.2f", area(r));

	}

}
