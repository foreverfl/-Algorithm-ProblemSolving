package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_01247_Sign {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int repeat = 3;
		while (repeat-- > 0) {

			int N = Integer.parseInt(br.readLine());

			BigInteger zero = BigInteger.ZERO;
			BigInteger sum = BigInteger.ZERO;
			while (N-- > 0) {
				BigInteger tmp = new BigInteger(br.readLine());
				sum = sum.add(tmp);
			}
			if (sum.compareTo(zero) > 0)
				sb.append("+").append('\n');
			else if (sum.compareTo(zero) < 0)
				sb.append("-").append('\n');
			else
				sb.append("0").append('\n');

		}

		System.out.println(sb.toString());

	}

}
