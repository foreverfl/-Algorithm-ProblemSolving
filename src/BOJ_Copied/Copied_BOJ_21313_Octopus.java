package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_21313_Octopus {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String res = "1 2 1 2";
		if (N == 4) {
			System.out.println(res);
			return;
		} else {
			for (int i = 5; i <= N; i++) {
				if (i % 2 == 1) {
					if (i == N) {
						res += " 3";
					} else {
						res += " 1";
					}
				} else {
					res += " 2";
				}
			}
		}

		System.out.println(res.trim());
	}

}
