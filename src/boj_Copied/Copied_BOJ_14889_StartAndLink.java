package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_14889_StartAndLink {

	static int N;
	static int[][] map;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0);
		System.out.println(min);

	}

	static void combi(int idx, int depth) {
		if (depth == N / 2) {
			diff();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				combi(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}

	static void diff() {
		int team_start = 0;
		int team_link = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visit[i] == true && visit[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				else if (visit[i] == false && visit[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}

		int val = Math.abs(team_start - team_link);

		if (val == 0) { // There is no need to search more if the value is the '0'.
			System.out.println(val);
			System.exit(0);
		}

		min = Math.min(val, min);

	}

}

// reference: https://st-lab.tistory.com/122
