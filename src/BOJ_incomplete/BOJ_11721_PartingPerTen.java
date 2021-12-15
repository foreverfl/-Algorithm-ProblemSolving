package BOJ_incomplete;

import java.util.Scanner;

public class BOJ_11721_PartingPerTen {
	@SuppressWarnings("resource")
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		while (true) {
			if (str.length() < 10) {
				System.out.println(str);
				break;
			} else {
				System.out.println(str.substring(0, 10));
				str = str.substring(10);
			}

		}
	}
}
