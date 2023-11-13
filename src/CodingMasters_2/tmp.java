package CodingMasters_2;

import java.util.ArrayList;
import java.util.List;

public class tmp {
    public static void main(String[] args) {
        // 노드의 개수
        int N = 5;

        // 간선 목록 (양방향 간선)
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[] { 1, 2 });
        edges.add(new int[] { 2, 3 });
        edges.add(new int[] { 3, 4 });
        edges.add(new int[] { 4, 5 });
        edges.add(new int[] { 5, 1 }); // 사이클을 만드는 간선

        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }

        // 사이클 탐지
        boolean[] visited = new boolean[N];
        boolean hasCycle = false;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, graph)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println("Does the graph have a cycle? " + hasCycle);
    }

    public static boolean dfs(int current, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[current] = true;

        for (int i : graph.get(current)) {
            if (!visited[i]) {
                if (dfs(i, current, visited, graph)) {
                    return true;
                }
            } else if (i != parent) { // 사이클을 발견한 경우
                return true;
            }
        }
        return false;
    }
}
