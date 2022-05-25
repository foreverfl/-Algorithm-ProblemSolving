package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_11051_BinomialCoefficient {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger mod = new BigInteger("10007");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		BigInteger up = BigInteger.ONE;
		for (int i = N; i > N - K; i--) {
			BigInteger tmp = new BigInteger(Integer.toString(i));
			up = up.multiply(tmp);
		}

		BigInteger down = BigInteger.ONE;
		for (int i = 1; i <= K; i++) {
			BigInteger tmp = new BigInteger(Integer.toString(i));
			down = down.multiply(tmp);
		}

		BigInteger result = up.divide(down).mod(mod);

		System.out.println(result);
	}

}
