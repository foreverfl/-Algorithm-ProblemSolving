package BOJ;

import java.util.Scanner;

public class BOJ_10162_MicrowaveOven {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int b300 = 300, b60 = 60, b10 = 10, cnt300 = 0, cnt60 = 0, cnt10 = 0; // b = button, cnt = count
		int T = sc.nextInt();

		if (T >= b300) { // '>' causes a wrong answer to occur.
			cnt300 = T / b300;
			T = T % b300;
		}

		if (T >= b60) {
			cnt60 = T / b60;
			T = T % b60;
		}

		if (T >= b10) {
			cnt10 = T / b10;
			T = T % b10;
		}

		if (T == 0) {
			System.out.println(cnt300 + " " + cnt60 + " " + cnt10);
		} else {
			System.out.println(-1);
		}

	}

}
