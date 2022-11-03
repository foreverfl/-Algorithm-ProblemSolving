package boj;

import java.util.Scanner;

public class BOJ_10953_APlusBMinus6 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String arr[] = new String[T];

		for (int i = 0; i < T; i++) {
			arr[i] = sc.next();
		}

		for (int i = 0; i < T; i++) {
			String calculation[] = arr[i].split(",");

			int result = Integer.parseInt(calculation[0]) + Integer.parseInt(calculation[1]);

			System.out.println(result);
		}
	}
}
