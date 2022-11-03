package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01769_MultiplicationOfThree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String X = br.readLine();

		int cnt = 0;
		while (true) {
			if (X.length() == 1)
				break;
			cnt++;
			X = check(X);
		}
		sb.append(cnt).append('\n');

		if (Integer.parseInt(X) % 3 == 0)
			sb.append("YES");
		else
			sb.append("NO");

		System.out.println(sb.toString());
	}

	private static String check(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		String result = Integer.toString(sum);
		return result;
	}

}
