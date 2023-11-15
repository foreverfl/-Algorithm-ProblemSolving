package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solving_7888_Neighbor {

    static class Edge {
        int e;
        int w;

        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[] weight = new int[N];
        boolean[] visited = new boolean[N];
        int max_weight = Integer.MIN_VALUE;
        int max_idx = -1; // 그래프 탐색 시작점
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(br.readLine());
            if (weight[i] >= max_weight) {
                max_idx = i;
            }
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int totalCost = dfs(graph, weight, visited, max_idx, K);
        System.out.println(totalCost);

    }

    public static int dfs(List<List<Integer>> graph, int[] weight, boolean[] visited, int current, int K) {
        visited[current] = true;
        int cost = 0;

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                int weightDiff = Math.abs(weight[current] - weight[neighbor]); // 현재 정점과 이웃한 정점 간의 가중치 차이

                if (weightDiff > K) {
                    int needed = weightDiff - K;
                    weight[neighbor] += needed; // 이웃 정점의 가중치를 증가시킴
                    cost += needed;
                }

                cost += dfs(graph, weight, visited, neighbor, K);
            }
        }

        return cost;
    }
}
