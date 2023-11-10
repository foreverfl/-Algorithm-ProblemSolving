package algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        // 간선을 가중치에 따라 정렬하기 위한 메소드
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Graph {
        int vertices; // 정점의 수
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        // 그래프에 간선을 추가하는 메소드
        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        // 크루스칼 알고리즘을 구현한 메소드
        public void kruskalMST() {
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            // 모든 간선을 우선순위 큐에 추가
            for (Edge edge : allEdges) {
                pq.add(edge);
            }

            // 각 정점의 부모를 저장할 배열 생성
            int[] parent = new int[vertices];

            // 모든 정점에 대해 make set 연산 수행
            makeSet(parent);

            ArrayList<Edge> mst = new ArrayList<>();

            // 간선의 수가 정점의 수 - 1이 될 때까지 반복
            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                // 사이클이 생기는지 확인
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if (x_set != y_set) {
                    // 사이클을 형성하지 않으면 MST에 추가
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }

            // 최소 스패닝 트리 출력
            printMST(mst);
        }

        // 각 정점에 대한 집합을 초기화하는 메소드
        public void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        // x가 속한 집합의 루트를 찾는 메소드
        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent, parent[vertex]);
            }
            return parent[vertex];
        }

        // 두 정점을 연결하는 union 연산을 수행하는 메소드
        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            parent[y_set_parent] = x_set_parent;
        }

        // MST의 결과를 출력하는 메소드
        public void printMST(ArrayList<Edge> mst) {
            for (int i = 0; i < mst.size(); i++) {
                Edge edge = mst.get(i);
                System.out.println("Edge: " + edge.source + " - " + edge.destination +
                        " weight: " + edge.weight);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.kruskalMST(); // 최소 스패닝 트리를 찾아서 출력
    }
}
