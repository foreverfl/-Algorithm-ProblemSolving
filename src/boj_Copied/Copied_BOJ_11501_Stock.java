package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_11501_Stock {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		long ans[] = new long[T];

		for (int n = 0; n < T; n++) {
			int day = Integer.parseInt(br.readLine());
			long stocks[] = new long[day];
			long max = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < day; i++) {
				stocks[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = day - 1; i >= 0; i--) {
				if (stocks[i] > max) {
					max = stocks[i];
				} else {
					ans[n] += (max - stocks[i]);
				}
			}
		}

		for (long i : ans) {
			System.out.println(i);
		}
	}

}

// reference: https://velog.io/@sukong/%EB%B0%B1%EC%A4%80-11501-%EC%A3%BC%EC%8B%9D
