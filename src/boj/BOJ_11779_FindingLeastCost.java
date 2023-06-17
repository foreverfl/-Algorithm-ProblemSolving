package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class BOJ_11779_FindingLeastCost {
    public static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i ++) {
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);
            int d = Integer.parseInt(tmp[2]);
            graph.get(s).add(new Edge(e, d));
        }

        String[] tmp = br.readLine().split(" ");
        int start = Integer.parseInt(tmp[0]);
        int end = Integer.parseInt(tmp[1]);

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        int[] prev = new int[n + 1];
        Arrays.fill(prev, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int vertex = current.destination;
            int weight = current.weight;

            if (weight > distances[vertex]) {
                continue;
            }

            for (Edge edge : graph.get(vertex)) {
                int newWeight = weight + edge.weight;
                if (newWeight < distances[edge.destination]) {
                    distances[edge.destination] = newWeight;
                    prev[edge.destination] = vertex;
                    pq.offer(new Edge(edge.destination, newWeight));
                }
            }
        }

        int shortestDistance = distances[end];
        System.out.println(shortestDistance);

        Stack<Integer> path = new Stack<>();
        int city = end;
        while (city != -1) {
            path.push(city);
            city = prev[city];
        }

        System.out.println(path.size());

        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }
}
