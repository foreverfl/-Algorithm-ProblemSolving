package boj_Copied;

import java.util.Scanner;

public class Copied_BOJ_02443_PrintingStars6 {
	@SuppressWarnings("resource")
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			for (int j = 0; j < 2 * (T - i) - 1; j++)
				System.out.print("*");
			System.out.println(" ");
		}

	}

}
