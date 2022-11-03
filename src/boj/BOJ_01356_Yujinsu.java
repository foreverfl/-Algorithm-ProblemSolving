package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01356_Yujinsu {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		String first = "";
		String last = "";
		boolean flag = false;
		for (int i = 0; i < N.length() - 1; i++) {

			for (int j = 0; j < i + 1; j++) {
				first += N.charAt(j);
			}
			for (int j = i + 1; j < N.length(); j++) {
				last += N.charAt(j);
			}

			if (check(first, last))
				flag = true;

			first = "";
			last = "";
		}

		if (flag) 
			System.out.println("YES");
		 else 
			System.out.println("NO");
		
	}

	private static boolean check(String a, String b) {
		int tmp_a = 1;
		for (int i = 0; i < a.length(); i++) {
			tmp_a *= a.charAt(i) - '0';
		}

		int tmp_b = 1;
		for (int i = 0; i < b.length(); i++) {
			tmp_b *= b.charAt(i) - '0';
		}

		if (tmp_a == tmp_b)
			return true;
		else
			return false;
	}

}
