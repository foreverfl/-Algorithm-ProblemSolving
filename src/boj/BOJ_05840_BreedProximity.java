package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_05840_BreedProximity {

	private static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int ans = -1;

		for (int i = 0; i < N; i++) {
			for (int j = i - 1; j >= i - K; j--) {
				if (!isValid(j))
					break;

				if (arr[i] == arr[j]) {
					ans = Math.max(ans, arr[i]);
				}
			}

			for (int j = i + 1; j <= i + K; j++) {
				if (!isValid(j))
					break;

				if (arr[i] == arr[j]) {
					ans = Math.max(ans, arr[i]);
				}
			}

		}

		System.out.println(ans);
	}

	private static boolean isValid(int num) {
		if (num >= 0 && num < N)
			return true;

		return false;
	}

}
