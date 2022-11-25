package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18256_InterleavedPeriodicString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String str = br.readLine();

			if (str.contains("0") && str.contains("1")) {
				System.out.println(2);
			} else {
				System.out.println(1);
			}

		}
	}

}
