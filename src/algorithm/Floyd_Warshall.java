package algorithm;

public class Floyd_Warshall {
	
	public static int floyd_warshall(int N, int[][] road, int K) {
		int dist[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = 500000;
			}
		}

		for (int i = 0; i < road.length; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int cost = road[i][2];
			dist[a][b] = Math.min(dist[a][b], cost);
			dist[b][a] = Math.min(dist[b][a], cost);
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[1][i] <= K) {
				answer++;
			}
		}

		return answer;
	}
}
