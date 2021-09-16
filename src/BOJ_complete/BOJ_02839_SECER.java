package BOJ_complete;

import java.util.Scanner;

public class BOJ_02839_SECER {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		if (a == 1 || a == 2 || a == 4 || a == 7) {
			System.out.println(-1);
		} else if (a % 5 == 0) {
			System.out.println(a / 5);
		} else if (a % 5 == 1) {
			System.out.println((a / 5) - 1 + 2);
		} else if (a % 5 == 2) {
			System.out.println((a / 5) - 2 + 4);
		} else if (a % 5 == 3) {
			System.out.println(a / 5 + 1);
		} else if (a % 5 == 4) {
			System.out.println((a / 5) - 1 + 3);
		}
	}

}
