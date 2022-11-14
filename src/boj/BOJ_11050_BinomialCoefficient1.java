package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050_BinomialCoefficient1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int numerator = makeFactorial(N);
		int denominator = makeFactorial(K) * makeFactorial(N - K);

		int ans = numerator / denominator;

		System.out.println(ans);
	}

	public static int makeFactorial(int num) {
		int res = 1;
		for (int i = num; i >= 1; i--) {
			res *= i;
		}

		return res;
	}

}
