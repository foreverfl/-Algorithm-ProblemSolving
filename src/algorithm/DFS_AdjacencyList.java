package algorithm;

public class DFS_AdjacencyList {
    private static int[][] adjMatrix;
    private static boolean[] visited;

    public static void main(String[] args) {
        int vertices = 4;
        addEdge(0, 1, vertices);
        addEdge(0, 2, vertices);
        addEdge(1, 2, vertices);
        addEdge(2, 0, vertices);
        addEdge(2, 3, vertices);
        addEdge(3, 3, vertices);

        System.out.println("Depth First Traversal starting from vertex 2:");
        DFS(2);
    }

    // 그래프 초기화 및 간선 추가
    public static void addEdge(int src, int dest, int vertices) {
        if (adjMatrix == null) {
            adjMatrix = new int[vertices][vertices];
            visited = new boolean[vertices];
        }
        adjMatrix[src][dest] = 1;
    }

    // DFS 알고리즘
    public static void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < adjMatrix[vertex].length; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

}
