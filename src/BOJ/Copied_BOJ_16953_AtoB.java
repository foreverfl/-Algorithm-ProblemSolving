package BOJ;

import java.util.Scanner;

public class Copied_BOJ_16953_AtoB {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int cnt = 1;
		while (a != b) {
			if (b < a) {
				System.out.println(-1);
				System.exit(0);
			}

			if (b % 10 == 1) {
				b /= 10;
			} else if (b % 2 == 0) {
				b /= 2;
			} else {
				System.out.println(-1); // important
				System.exit(0);
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}