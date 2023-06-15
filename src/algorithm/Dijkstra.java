package algorithm;

public class Dijkstra {
        public static void dijkstra(int[][] graph, int start) {
        int numVertices = graph.length;
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distances[start] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            // minDistance와 minIndex를 찾기
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && distances[minIndex] != Integer.MAX_VALUE &&
                        distances[minIndex] + graph[minIndex][j] < distances[j]) {
                    distances[j] = distances[minIndex] + graph[minIndex][j];
                }
            }
        }

        // 최단 경로 출력
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": Distance = " + distances[i]);
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int startVertex = 0;
        dijkstra(graph, startVertex);
    }
}
