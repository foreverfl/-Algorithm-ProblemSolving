package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_01956_Exercise {

	static int[][] dist;
	static final int INF = 4000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		dist = new int[V + 1][V + 1];

		for (int[] arr : dist)
			Arrays.fill(arr, INF);

		for (int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			dist[a][b] = c;
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					if (j == k || i == j || i == k)
						continue;

					if (dist[j][k] > dist[j][i] + dist[i][k])
						dist[j][k] = dist[j][i] + dist[i][k];

				}
			}
		}

		// checking whether the cycle exists or not
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j)
					continue;
				if (dist[i][i] > dist[i][j] + dist[j][i])
					dist[i][i] = dist[i][j] + dist[j][i];
			}
		}

		int max = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++)
			if (dist[i][i] != INF)
				max = Math.min(max, dist[i][i]);

		int answer = -1;
		if (max != Integer.MAX_VALUE)
			answer = max;
		System.out.print(answer);
	}

}

// reference: https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-1956-%EC%9A%B4%EB%8F%99-Java%EC%9E%90%EB%B0%94-tz9bi3cj
