package boj;

import java.util.Scanner;

public class BOJ_10952_APlusBMinus5 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		while (true) {
			a = sc.nextInt();
			b = sc.nextInt();
			if (a == 0 && b == 0)
				break;
			System.out.println(a + b);

		}

	}

}
