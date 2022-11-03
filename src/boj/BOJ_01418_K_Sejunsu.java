package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01418_K_Sejunsu {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];

		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (arr[i] != 0)
				continue;
			for (int j = i; j <= N; j += i) {
				arr[j] = Math.max(arr[j], i);
			}
		}

		for (int i = 1; i <= N; i++) {
			if (arr[i] <= K)
				cnt++;
		}

		System.out.println(cnt);
	}

}

// reference: https://happy-family.tistory.com/entry/%EB%B0%B1%EC%A4%801418%EB%B2%88-K%EC%84%B8%EC%A4%80%EC%88%98%EB%B8%8C%EB%A1%A0%EC%A6%881