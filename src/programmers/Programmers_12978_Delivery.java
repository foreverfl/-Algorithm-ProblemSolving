package programmers;

public class Programmers_12978_Delivery {

	public static void main(String[] args) {
		System.out.println(solution(5,
				new int[][] { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } }, 3));
		System.out.println(solution(6, new int[][] { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 },
				{ 3, 5, 3 }, { 5, 6, 1 } }, 4));
	}

	public static int solution(int N, int[][] road, int K) {
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
