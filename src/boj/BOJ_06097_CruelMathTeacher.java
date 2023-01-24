package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_06097_CruelMathTeacher {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		BigInteger N = new BigInteger(st.nextToken());
		BigInteger P = new BigInteger(st.nextToken());

		BigInteger ans = N.pow(P.intValue());
		String ansAsString = ans.toString();

		for (int i = 1; i <= ansAsString.length(); i++) {
			sb.append(ansAsString.charAt(i - 1));

			if (i % 70 == 0) {
				sb.append('\n');
			}
		}

		System.out.print(sb.toString());

	}

}
