package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14920_3nPlus1Sequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 1;
		if (N == 1) {
			System.out.println(1);
			System.exit(0);
		}

		while (true) {
			ans++;

			if (N % 2 == 1) {
				N = 3 * N + 1;
			} else {
				N /= 2;
			}

			if (N == 1)
				break;
		}

		System.out.println(ans);
	}

}
