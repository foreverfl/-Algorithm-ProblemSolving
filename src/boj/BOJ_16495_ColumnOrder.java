package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16495_ColumnOrder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		long ans = 0;
		int pow = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			int now = str.charAt(i) - 'A' + 1;
			ans += (Math.pow(26, pow++) * now);
		}

		System.out.println(ans);

	}

}
