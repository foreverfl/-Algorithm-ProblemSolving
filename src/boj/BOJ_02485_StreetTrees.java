package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02485_StreetTrees {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] dists = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			dists[i] = arr[i + 1] - arr[i];
		}

		int GCD = dists[0];
		for (int i = 1; i < N - 1; i++) {
			GCD = calcGCD(dists[i], GCD);
		}

		int ans = 0;
		for (int i = 0; i < N - 1; i++) {
			ans += (dists[i] / GCD - 1);
		}

		System.out.print(ans);

	}

	private static int calcGCD(int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (a % b == 0) {
			return b;
		}
		return calcGCD(b, a % b);
	}

}
