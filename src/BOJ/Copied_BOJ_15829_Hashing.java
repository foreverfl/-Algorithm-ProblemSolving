package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_15829_Hashing {

	static final int n = 31;
	static final int mod = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String input = br.readLine();
		long pow = 1;
		long answer = 0;

		for (int i = 0; i < L; i++) {
			answer += (input.charAt(i) - 'a' + 1) * pow;
			pow = (pow *= n) % mod;
		}
		System.out.println(answer % mod);
	}
}

// reference: https://prod.velog.io/@sennys2/%EB%B0%B1%EC%A4%8015829.HashingJava