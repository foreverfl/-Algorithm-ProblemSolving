package BOJ_incomplete;

import java.util.Scanner;

public class Copied_BOJ_10250_ACMHotel {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			if (N % H == 0) { // in case of 'N == H'
				System.out.println((H * 100) + (N / H)); // floor + unit

			} else {
				System.out.println(((N % H) * 100) + ((N / H) + 1)); // floor + unit
			}
		}
	}
}