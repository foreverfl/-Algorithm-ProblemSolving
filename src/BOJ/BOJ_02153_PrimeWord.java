package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02153_PrimeWord {

	static boolean prime[] = new boolean[1101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (Character.isUpperCase(tmp)) {
				sum += tmp - 'A' + 1 + 26;
			} else {
				sum += tmp - 'a' + 1;
			}
		}

		int N = 1100; // a maximum value is the '1040'.

		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i)
					prime[j] = true;
			}
		}
		prime[1] = false;

		if (!prime[sum]) {
			System.out.println("It is a prime word.");
		} else {
			System.out.println("It is not a prime word.");
		}

	}

}
