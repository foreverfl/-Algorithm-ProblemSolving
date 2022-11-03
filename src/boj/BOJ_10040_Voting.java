package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10040_Voting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] game = new int[N];
		int M = Integer.parseInt(st.nextToken());
		int[] member = new int[M];

		for (int i = 0; i < N; i++)
			game[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++)
			member[i] = Integer.parseInt(br.readLine());

		int[] vote = new int[N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (member[i] >= game[j]) {
					vote[j]++;
					break;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, vote[i]);
		}

		for (int i = 0; i < N; i++) {
			if (max == vote[i]) {
				System.out.println(i + 1);
				break;
			}
		}

	}

}
