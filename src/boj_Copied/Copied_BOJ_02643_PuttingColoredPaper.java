package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_02643_PuttingColoredPaper {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<int[]>();

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			if (arr[i][1] > arr[i][0]) {
				list.add(new int[] { arr[i][1], arr[i][0] });
			} else {
				list.add(new int[] { arr[i][0], arr[i][1] });
			}
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else
					return o1[0] - o2[0];
			}
		});

		// LCS(Longest Increasing Subsequence)
		int res = 0;
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			int cur[] = list.get(i);
			for (int j = 0; j < i; j++) {
				int next[] = list.get(j);
				if (cur[0] >= next[0] && cur[1] >= next[1]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i]++;
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}

}

// reference: https://kistone.tistory.com/38
