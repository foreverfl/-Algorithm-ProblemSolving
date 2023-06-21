package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_02211_RecoveryingNetwork {
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        int[] distances = dijkstra(graph, 1, N);
        int[] parent = new int[N + 1]; 

        for (int i = 2; i <= N; i++) {
            for (Edge edge : graph.get(i)) {
                int to = edge.to;
                int weight = edge.weight;

                if (distances[to] + weight == distances[i]) {
                    parent[i] = to;
                    break;
                }
            }
        }

        System.out.println(N - 1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i] + " " + i);
        }

    }

    public static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int start, int N) {
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int to = current.to;
            int weight = current.weight;

            if (distances[to] < weight) {
                continue;
            }

            for (Edge next : graph.get(to)) {
                int nextTo = next.to;
                int nextWeight = weight + next.weight;

                if (nextWeight < distances[nextTo]) {
                    distances[nextTo] = nextWeight;
                    pq.offer(new Edge(nextTo, nextWeight));
                }
            }
        }

        return distances;
    }
}

// reference: https://yabmoons.tistory.com/444