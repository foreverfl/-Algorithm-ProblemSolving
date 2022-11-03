package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01493_FillingTheBox {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		int[] cube = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			cube[len] = cnt;
		}

		long before = 0;
		long ans = 0;

		for (int i = N - 1; i >= 0; i--) {
			before <<= 3;

			long possibleCube = (long) (L >> i) * (W >> i) * (H >> i) - before;
			long newCube = Math.min((long) cube[i], possibleCube);

			before += newCube;
			ans += newCube;
		}

		if (before == (long) L * W * H) { // The 'before' has to be same with the 'L * W * H'.
			System.out.println(ans);
		} else {
			System.out.println("-1");
		}

	}

}

// reference: https://steady-coding.tistory.com/14
