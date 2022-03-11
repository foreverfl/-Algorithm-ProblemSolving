package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01013_Contact {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String str = br.readLine();
			check(str);
		}

		System.out.println(sb.toString());
	}

	private static void check(String str) {
		String pattern = "(100+1+|01)+";
		
		if (str.matches(pattern))
			sb.append("YES").append('\n');
		else
			sb.append("NO").append('\n');

	}

}

// reference: https://moonsbeen.tistory.com/241