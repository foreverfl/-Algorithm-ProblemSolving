package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24196_GomdaOrd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String ans = "";
		int idx = 0;
		while (true) {
			char now = str.charAt(idx);
			ans += now;
			idx += now - 'A' + 1;

			if (idx > str.length() - 1)
				break;
		}

		System.out.println(ans);

	}
}
