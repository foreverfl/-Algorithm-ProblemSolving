package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25501_GeniusOfRecursion {

	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String str = br.readLine();
			cnt = 0;
			sb.append(isPalindrome(str) + " " + (cnt + 1)).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static int recursion(String str, int l, int r) {
		if (l >= r)
			return 1;
		else if (str.charAt(l) != str.charAt(r))
			return 0;
		else {
			cnt++;
			return recursion(str, l + 1, r - 1);
		}

	}

	private static int isPalindrome(String str) {
		return recursion(str, 0, str.length() - 1);
	}

}
