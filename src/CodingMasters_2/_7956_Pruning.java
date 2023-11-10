package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _7956_Pruning {

    static class Edge implements Comparable<Edge> {
        int start;
        int dest;
        int weight;

        public Edge(int start, int dest, int weight) {
            this.start = start;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return compareEdge.weight - this.weight; // 내림차순 정렬
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices + 1;
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        // 크루스칼
        public int kruskalMST() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges);
            int[] parent = new int[vertices];
            makeSet(parent);

            int maxBeauty = 0;

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                int x_set = find(parent, edge.start);
                int y_set = find(parent, edge.dest);

                if (x_set != y_set) {
                    maxBeauty += edge.weight;
                    union(parent, x_set, y_set);
                }
            }
            return maxBeauty;
        }

        // 유니온 파인드
        public void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex)
                parent[vertex] = find(parent, parent[vertex]);
            return parent[vertex];
        }

        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            parent[y_set_parent] = x_set_parent;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] beauty = new int[N + 1];
        input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            beauty[i] = Integer.parseInt(input[i - 1]);
        }

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int weight = beauty[u] + beauty[v];
            graph.addEdge(u, v, weight);
        }

        System.out.println(graph.kruskalMST());

    }
}
