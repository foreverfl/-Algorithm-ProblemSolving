package algorithm;

public class Floyd_Warshall {
	
	public static final int INF = 9999999; // 무한대를 나타내는 값

    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        // 최단 거리 배열을 초기화합니다.
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // 중간 정점을 거쳐가는 모든 경로를 고려하여 최단 거리를 업데이트합니다.
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 최단 거리 출력
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4; // 정점의 개수

        int[][] graph = {
            {0, 5, INF, 8},
            {7, 0, 9, INF},
            {2, INF, 0, 4},
            {INF, INF, 3, 0}
        };

        floydWarshall(graph, V);
    }
}
