package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01668_ArrangingTrophies {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] arr_reversed = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
			arr_reversed[j] = arr[i];
		}

		int cnt = 1;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N - 1; i++) {
			max = Math.max(arr[i], max);

			if (max >= arr[i + 1])
				continue;

			cnt++;
		}

		sb.append(cnt).append('\n');

		cnt = 1;
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N - 1; i++) {
			max = Math.max(arr_reversed[i], max);

			if (max >= arr_reversed[i + 1])
				continue;

			cnt++;
		}

		sb.append(cnt).append('\n');

		System.out.println(sb.toString());

	}

}

// reference: https://ju-nam2.tistory.com/114
