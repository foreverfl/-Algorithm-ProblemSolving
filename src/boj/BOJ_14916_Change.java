package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916_Change {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 1 || n == 3) {
			System.out.println(-1);
			System.exit(0);
		}

		int ans = 0;
		if ((n - 5 * (n / 5)) % 2 == 0) {
			ans += n / 5;
			n -= (n / 5 * 5);
			ans += n / 2;
		} else if ((n - 5 * (n / 5 - 1)) % 2 == 0) {
			ans += (n / 5 - 1);
			n -= ((n / 5 - 1) * 5);
			ans += n / 2;
		} else {
			ans = -1;
		}

		System.out.println(ans);
	}

}
