package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_05988_EvenOdd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		BigInteger two = new BigInteger("2");
		BigInteger zero = BigInteger.ZERO;

		for (int i = 0; i < N; i++) {
			BigInteger input = new BigInteger(br.readLine());
			if (input.mod(two) == zero)
				sb.append("even").append('\n');
			else
				sb.append("odd").append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
