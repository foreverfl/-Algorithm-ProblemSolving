package BOJ_complete;

import java.util.Scanner;

public class BOJ_01085_EscapingFromRectangular {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		int to_top = h - y;
		int to_bottom = y;
		int to_right = w - x;
		int to_left = x;
		int result = Math.min(Math.min(to_top, to_bottom), Math.min(to_right, to_left));

		System.out.println(result);

	}
}
