package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_04447_TheGoodTheBad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String hero = br.readLine();
			sb.append(hero + " is " + decide(hero)).append('\n');
		}

		System.out.println(sb.toString().trim());

	}

	private static String decide(String str) {
		str = str.toLowerCase();
		int cnt_g = 0;
		int cnt_b = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'g')
				cnt_g++;
			else if (str.charAt(i) == 'b')
				cnt_b++;
		}

		if (cnt_g > cnt_b) {
			return "GOOD";
		} else if (cnt_g < cnt_b) {
			return "A BADDY";
		} else {
			return "NEUTRAL";
		}

	}

}
