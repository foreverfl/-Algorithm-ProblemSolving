package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_04458_CapitalizeTheFirstLetter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {

			sb.append(toUpperCase(br.readLine()));
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static String toUpperCase(String str) {
		String result = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
		return result;
	}
}
