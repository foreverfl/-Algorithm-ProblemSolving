package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01940_Joomoong {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] material = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			material[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int start = 0; start < N; start++) {
			int sum = 0;
			int end = start + 1;

			while (end < N) {
				sum = material[start];
				sum += material[end++];
				if (sum == M) {
					cnt++;
					break;
				}
			}
		}

		System.out.println(cnt);

	}
}

// reference: https://hidelookit.tistory.com/178