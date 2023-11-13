package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _7918_CommutingTime {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        public String toString() {
            return "(" + dest + ", " + weight + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            graph.get(u - 1).add(new Edge(v - 1, w));

        }

        int toSchool = findShortestPath(graph, 0, K - 1);
        int toWorkplace = findShortestPath(graph, K - 1, N - 1);
        System.out.println(toSchool + toWorkplace);
    }

    public static int findShortestPath(List<List<Edge>> graph, int start, int destination) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int vertex = current.dest;

            if (vertex == destination) {
                return distance[vertex];
            }

            for (Edge neighbor : graph.get(vertex)) {
                int newDistance = distance[vertex] + neighbor.weight;
                if (newDistance < distance[neighbor.dest]) {
                    distance[neighbor.dest] = newDistance;
                    pq.offer(new Edge(neighbor.dest, newDistance));
                }
            }
        }

        return distance[destination];
    }

}
