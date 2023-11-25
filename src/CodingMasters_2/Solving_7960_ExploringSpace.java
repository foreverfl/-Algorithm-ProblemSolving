package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solving_7960_ExploringSpace {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);
            edges.add(new Edge(u, v, w));
        }

        // List<List<Edge>> connectedComponents = findConnectedComponents(graph, N);
        // int totalCost = calculateMSTCost(edges, N, K);
    }

    public static List<List<Edge>> findConnectedComponents(List<Edge>[] graph, int N) {
        boolean[] visited = new boolean[N];
        List<List<Edge>> components = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                List<Edge> component = new ArrayList<>();
                bfs(graph, visited, i, component);
                components.add(component);
            }
        }

        return components;
    }

    public static void bfs(List<Edge>[] graph, boolean[] visited, int start, List<Edge> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Edge edge : graph[node]) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.offer(edge.dest);
                    component.add(edge);
                }
            }
        }
    }

    // 유니온 파인드
    static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    // 주어진 그래프의 모든 연결 성분에 대한 최소 스패닝 트리 비용을 계산
    static int calculateMSTCost(List<Edge> edges, int N, int K) {
        Collections.sort(edges);

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cost = 0;
        for (Edge edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y) {
                cost += edge.weight;
                union(parent, x, y);
            }
        }

        return Math.min(cost, K); // MST 총 비용이 K보다 크면 K로 대체
    }
}
