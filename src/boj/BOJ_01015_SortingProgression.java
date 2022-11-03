package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01015_SortingProgression {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] not_ascending = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			not_ascending[i] = arr[i];
		}

		Arrays.sort(not_ascending);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i] == not_ascending[j] && not_ascending[j] != -1) {
					sb.append(j + " ");
					not_ascending[j] = -1;
					break;
				}
			}
		}

		System.out.println(sb.toString());

	}

}
