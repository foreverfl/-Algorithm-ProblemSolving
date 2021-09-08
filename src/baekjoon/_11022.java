package baekjoon;

import java.util.Scanner;

public class _11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int a = 0, b = 0;

		for (int i = 0; i < testcase; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println("Case #" + (i + 1) + ": " + a + " + " + b + " = " + (a + b));
		}
		sc.close();
	}
}
