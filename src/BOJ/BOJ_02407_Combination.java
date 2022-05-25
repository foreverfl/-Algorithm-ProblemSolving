package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_02407_Combination {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger up = makeFactorial(n);
		BigInteger down = makeFactorial(n - m).multiply(makeFactorial(m));
		BigInteger res = up.divide(down);

		System.out.println(res);
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
