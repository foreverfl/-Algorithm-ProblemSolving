package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09996_VJEKO {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		pattern = pattern.replace("*", "[a-z]*");
		pattern = "^" + pattern + "$";

		while (N-- > 0) {
			String str = br.readLine();
			if (str.matches(pattern))
				sb.append("DA").append('\n');
			else
				sb.append("NE").append('\n');
		}

		System.out.println(sb.toString());
	}

}
