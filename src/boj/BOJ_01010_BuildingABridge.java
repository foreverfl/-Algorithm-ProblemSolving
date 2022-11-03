package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_01010_BuildingABridge {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			BigInteger up = makeFactorial(M);
			BigInteger down = (makeFactorial(N).multiply(makeFactorial(M - N)));

			sb.append(up.divide(down)).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static BigInteger makeFactorial(int num) {
		BigInteger res = BigInteger.ONE;
		for (int i = 1; i <= num; i++) {
			BigInteger tmp = new BigInteger(Integer.toString(i));
			res = res.multiply(tmp);
		}

		return res;
	}

}
