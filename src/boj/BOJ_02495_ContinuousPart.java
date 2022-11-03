package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02495_ContinuousPart {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		System.out.println(check(a));
		System.out.println(check(b));
		System.out.println(check(c));
	}

	private static int check(String str) {

		int max = 1; // basic value
		for (int i = 0; i < str.length(); i++) {
			int cnt = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					cnt++;
				} else {
					break;
				}
			}
			if (cnt >= max) {
				max = cnt;
			}
		}

		return max;
	}

}
