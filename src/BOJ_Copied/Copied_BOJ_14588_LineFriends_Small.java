package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_14588_LineFriends_Small {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] dist = new int[N + 1][N + 1];
		int[] left = new int[N + 1];
		int[] right = new int[N + 1];

		for (int i = 1; i < N; i++)
			for (int j = i; j <= N; j++) {
				if (i == j)
					dist[i][j] = 0;
				else {
					dist[i][j] = 987654321;
					dist[j][i] = 987654321;
				}
			}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			left[i] = Integer.parseInt(st.nextToken());
			right[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++)
			for (int j = i + 1; j <= N; j++)
				if ((left[i] <= left[j] && left[j] <= right[i]) || (left[i] <= right[j] && right[j] <= right[i])
						|| (left[j] <= left[i] && left[i] <= right[j])
						|| (left[j] <= right[i] && right[i] <= right[j])) {
					dist[i][j] = 1;
					dist[j][i] = 1;
				}
		// 1. i includes j
		// 2. -- __
		// 3. __ --
		// 4. j includes i

		for (int k = 1; k <= N; k++)
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];

		int question = Integer.parseInt(br.readLine());
		for (int i = 0; i < question; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(dist[a][b] == 987654321 ? -1 : dist[a][b]).append('\n');
		}

		System.out.println(sb.toString());
	}

}

// reference: https://imnotabear.tistory.com/242