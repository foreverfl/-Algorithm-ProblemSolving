package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20950_ArtistMimi {

	static int[][] colors;
	static boolean[] visited;
	static int[] gom_color;
	static int[] moon_color;
	static int N;
	static int cnt, ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		colors = new int[N][3];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			colors[i][0] = Integer.parseInt(st.nextToken());
			colors[i][1] = Integer.parseInt(st.nextToken());
			colors[i][2] = Integer.parseInt(st.nextToken());
		}

		moon_color = new int[3];
		gom_color = new int[3];
		st = new StringTokenizer(br.readLine());
		gom_color[0] = Integer.parseInt(st.nextToken());
		gom_color[1] = Integer.parseInt(st.nextToken());
		gom_color[2] = Integer.parseInt(st.nextToken());

		backTracking(0, 0);

		System.out.print(ans);

	}

	public static void backTracking(int depth, int cnt) {
		if (cnt >= 2)
			ans = Math.min(ans, Math.abs(moon_color[0] / cnt - gom_color[0])
					+ Math.abs(moon_color[1] / cnt - gom_color[1]) + Math.abs(moon_color[2] / cnt - gom_color[2]));
		for (int i = depth; i < N; i++) {
			if (!visited[i] && cnt <= 6) {
				visited[i] = true;
				moon_color[0] += colors[i][0];
				moon_color[1] += colors[i][1];
				moon_color[2] += colors[i][2];

				backTracking(i + 1, cnt + 1);

				visited[i] = false;
				moon_color[0] -= colors[i][0];
				moon_color[1] -= colors[i][1];
				moon_color[2] -= colors[i][2];
			}
		}

	}

}

// reference: https://github.com/kth990303/Baekjoon/blob/master/20950_backtracking.cpp