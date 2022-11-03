package boj_Copied;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Copied_BOJ_09012_Parenthesis {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			sb.append(solve(br.readLine())).append('\n');
		}
		System.out.println(sb);

	}

	public static String solve(String s) {

		int count = 0;

		for (char c : s.toCharArray()) {

			if (c == '(') {
				count++;
			} else if (count == 0) { // It excludes ')('.
				return "NO";
			} else {
				count--;
			}
		}

		if (count == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}
}