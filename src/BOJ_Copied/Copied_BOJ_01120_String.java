package BOJ_Copied;

import java.util.Scanner;

public class Copied_BOJ_01120_String {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int result = a.length(); // result �� All elements are different(initialization)

		for (int i = 0; i <= b.length() - a.length(); i++) {
			int cnt = 0;
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) != b.charAt(i + j))
					cnt++;
			}
			result = Math.min(cnt, result);
		}
		System.out.println(result);
	}

}
